import java.util.ArrayList;

public class Scene {

	private final Vec3 defaultColor = new Vec3(0, 0, 0);
	private final double epsilon = 0.001;
	private final int maxDepth = 2;

	private ArrayList<Primitive> objects = new ArrayList<Primitive>();
	private ArrayList<Light> lights = new ArrayList<Light>();

	public Scene() {

	}

	public void addObject(Primitive p) {
		objects.add(p);
	}

	public void addLight(Light l) {
		lights.add(l);
	}

	public Vec3 intersect(Ray ray, int depth) {
		if (depth == maxDepth) {
			return new Vec3(0, 0, 0);
		}
		
		Vec3 color = defaultColor;
		double minT = Double.POSITIVE_INFINITY;
		Primitive minObj = null;
		Vec3 minIntersect = null;
		for (Primitive obj : objects) {
			double[] solutions = obj.solve(ray);
			if (solutions != null) {
				for (int i = 0; i < solutions.length; i++) {
					if (solutions[i] < minT && solutions[i] > epsilon) {
						Vec3 intersectionPoint = ray.e.add(ray.d.scalarMultiply(solutions[i]));
						color = obj.material.aC.scalarMultiply(obj.material.aI);
						for (Light light : lights) {
							if (!shadowIntersect(intersectionPoint, light)) {
								color = color.add(light.doPingPongShade(ray,obj, intersectionPoint));
							}
						}
						minT = solutions[i];
						minObj = obj;
						minIntersect = intersectionPoint;
					}
				}
			}
		}

		if (minObj != null && minIntersect != null) {
			Vec3 n = minObj.getNormal(minIntersect).norm();
			Vec3 r = ray.d.minus(n.scalarMultiply(2 * (ray.d.dot(n)))).norm();
			Ray newRay = new Ray(minIntersect, r);
			color = color.add(intersect(newRay, depth + 1).scalarMultiply(minObj.material.reflection));
		}

		return color;
	}

	private boolean shadowIntersect(Vec3 origin, Light light) {
		Ray ray = new Ray(origin, light.position.minus(origin));
		for (Primitive obj : objects) {
			double[] solutions = obj.solve(ray);
			if (solutions != null) {
				for (int i = 0; i < solutions.length; i++) {
					if (solutions[i] > epsilon) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
