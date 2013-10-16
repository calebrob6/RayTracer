
public abstract class Primitive {

	public Material material = new Material();
	
	public abstract double[] solve(Ray r);
	public abstract Vec3 getNormal(Vec3 p);
	
}
