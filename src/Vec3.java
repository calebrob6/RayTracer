public class Vec3 {

	protected double[] vec = new double[3];

	public Vec3() {
		vec[0] = 0;
		vec[1] = 0;
		vec[2] = 0;
	}

	public Vec3(double x, double y, double z) {
		vec[0] = x;
		vec[1] = y;
		vec[2] = z;
	}

	public Vec3(double[] vals) {
		if (vals.length == 3) {
			vec = vals;
		} else {
			System.err.println("Vec3 needs to be instantiated with array of size 3");
			vec = null;
		}
	}

	public String toString() {
		if (vec != null) {
			return "(" + vec[0] + "," + vec[1] + "," + vec[2] + ")";
		}else{
			return "(NULL)";
		}
	}

	public double dot(Vec3 b){
		return this.vec[0]*b.vec[0] + this.vec[1]*b.vec[1]+ this.vec[2]*b.vec[2];
	}
	
	public Vec3 minus(Vec3 b){
		return new Vec3(this.vec[0]-b.vec[0],this.vec[1]-b.vec[1],this.vec[2]-b.vec[2]);
	}
	
	public Vec3 add(Vec3 b){
		return new Vec3(this.vec[0]+b.vec[0],this.vec[1]+b.vec[1],this.vec[2]+b.vec[2]);
	}
	
	public Vec3 scalarMultiply(double val){
		return new Vec3(this.vec[0]*val,this.vec[1]*val,this.vec[2]*val);
	}
	
	public Vec3 norm(){
		return this.scalarMultiply((1.0d/Math.sqrt(this.dot(this))));
	}
	
	public Vec3 cross(Vec3 b){
		return new Vec3(this.vec[1]*b.vec[2]-this.vec[2]*b.vec[1],
				this.vec[2]*b.vec[0]-this.vec[0]*b.vec[2],
				this.vec[0]*b.vec[1]-this.vec[1]*b.vec[0]);
	}
	
	public int getColor(){
		int a=255;
		int r = (int) Math.min(vec[0], 255);
		int g = (int) Math.min(vec[1], 255);
		int b = (int) Math.min(vec[2], 255);
		return (a << 24) | (r << 16) | (g << 8) | b;
	}
	
}
