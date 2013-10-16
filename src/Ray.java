
public class Ray {
	
	public Vec3 e,d;

	public Ray(Vec3 eye, Vec3 dir){
		this.e = eye;
		this.d = dir;
	}
	
	@Override
	public String toString(){
		return this.e.toString()+ " " + this.d.toString();
	}
	
}
