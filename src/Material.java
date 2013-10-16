public class Material {

	public double aI, dI, sI, sExp, reflection;
	public Color aC, dC, sC;

	public Material() {
		this.aI = 0.4;
		this.aC = new Color(100, 100, 100);
		this.dI = 0.9;
		this.dC = new Color(255, 0, 0);
		this.sI = 0.5;
		this.sC = new Color(0, 255, 0);
		this.sExp = 20;
		this.reflection = 0.5;
	}

}
