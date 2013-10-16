
public class Sphere extends Primitive {
	
	private Vec3 c;
	private int r;
	
	public Sphere(Vec3 center, int radius){
		this.c = center;
		this.r = radius;
	}
	
	/**
	 * Returns the two solutions if possible, else returns null
	 */
	public double[] solve(Ray r){
		double[] solutions = new double[2];
		
		Vec3 e = r.e;
		Vec3 d = r.d;
		
		
		double a = -d.dot(e.minus(c));
		double b = d.dot(d);
		double f = Math.pow(d.dot(e.minus(c)), 2) - (d.dot(d))*(e.minus(c).dot(e.minus(c)) - Math.pow(this.r,2));
		
		if(f>=0){
			solutions[0] = (a/b + Math.sqrt(f)/b);
			solutions[1] = (a/b - Math.sqrt(f)/b);
		}else{
			solutions = null;
		}
		
		return solutions;
	}

	@Override
	public Vec3 getNormal(Vec3 p) {
		return (p.minus(this.c)).scalarMultiply(1.0d/this.r);
	}
	
}
