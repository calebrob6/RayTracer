public class Material {

	public double aI, dI, sI, sExp, reflection;
	public Vec3 aC, dC, sC;

	public Material() {
		this.aI = 0.4;
		this.aC = new Vec3(100, 100, 100);
		this.dI = 0.9;
		this.dC = new Vec3(255, 0, 0);
		this.sI = 0.5;
		this.sC = new Vec3(0, 255, 0);
		this.sExp = 20;
		this.reflection = 0.5;
	}
	
	
	public Material(double aI,Vec3 aC, double dI, Vec3 dC, double sI, Vec3 sC, double sExp,double reflection){
		this.aI = aI;
		this.aC = aC;
		this.dI = dI;
		this.dC = dC;
		this.sI = sI;
		this.sC = sC;
		this.sExp = sExp;
		this.reflection = reflection;
	}

}
