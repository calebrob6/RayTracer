
public abstract class Light {

	public Vec3 position = null;
	public Vec3 I = null;
	public abstract Vec3 doPingPongShade(Ray r, Primitive obj, Vec3 intersectionPoint);

}
