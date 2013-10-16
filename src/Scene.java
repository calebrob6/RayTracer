import java.util.ArrayList;


public class Scene {
	
	private final Color defaultColor = new Color(0,0,0);
	private final double epsilon = 0.001;
	private final int maxDepth = 5;
	
	private ArrayList<Primitive> objects = new ArrayList<Primitive>();
	private ArrayList<Light> lights = new ArrayList<Light>();
	
	public Scene(){
		
	}
	
	public void addObject(Primitive p){
		objects.add(p);
	}
	
	public void addLight(Light l){
		lights.add(l);
	}
	
	public Color intersect(Ray r){
		Color color = defaultColor;
		double minT = Double.POSITIVE_INFINITY;
		for(Primitive p:objects){
			double[] solutions = p.solve(r);
			if(solutions!=null){
				for(int i=0;i<solutions.length;i++){
					if(solutions[i]<minT && solutions[i]>0){
						Vec3 intersectionPoint = r.e.add(r.d.scalarMultiply(solutions[i]));
						
					}
				}
			}
		}   
		
		//return Color.getRandomColor();
		return color;
	}

}
