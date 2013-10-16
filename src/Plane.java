
public class Plane extends Primitive {

	private Vec3 p;
	private Vec3 n;
	
	public Plane(Vec3 point, Vec3 normal){
		this.p = point;
		this.n = normal;
	}
	
	
	@Override
	public double[] solve(Ray r) {
		double[] solutions = new double[1];
		Vec3 e = r.e;
		Vec3 d = r.d;
		
		Vec3 t = e.minus(this.p);
		double a = d.dot(this.n);
		double b = t.dot(this.n);
		solutions[0] = -b/a;
		return solutions;
	}

	@Override
	public Vec3 getNormal(Vec3 p) {
		return this.n;
	}

}
