public class PointLight extends Light {

	public PointLight(Vec3 p) {
		this.position = p;
		this.I = new Vec3(1, 1, 1);
	}

	@Override
	public Vec3 doPingPongShade(Ray r, Primitive obj, Vec3 intersectionPoint) {

		Vec3 l = this.position.minus(intersectionPoint).norm();
		Vec3 v = r.e.minus(intersectionPoint).norm();
		Vec3 n = obj.getNormal(intersectionPoint).norm();
		Vec3 h = v.add(l).norm();

		Vec3 color0 = obj.material.dC.scalarMultiply(obj.material.dI).scalarMultiply(Math.max(0, n.dot(l)))
				.add(obj.material.sC.scalarMultiply(obj.material.sI).scalarMultiply(
								Math.pow(Math.max(0, n.dot(h)),obj.material.sExp)));

		return color0;

	}

}
