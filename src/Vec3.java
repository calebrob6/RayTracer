
public class Vec3 {
	
	private double[] vec = new double[3];
	
	public Vec3(){
		vec[0] = 0;
		vec[1] = 0;
		vec[2] = 0;
	}
	
	public Vec3(double x,double y,double z){
		vec[0] = x;
		vec[1] = y;
		vec[2] = z;
	}
	
	public Vec3(double[] vals){
		if(vals.length==3){
			vec = vals;
		}else{
			System.err.println("Vec3 needs to be instantiated with array of size 3");
			vec = null;
		}
	}

}
