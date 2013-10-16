import java.util.Random;

public class Color extends Vec3 {

	private int a, r, g, b;

	public Color() {
		super(0,0,0);
		this.a = 255;
	}
	
	public Color(int r, int g, int b) {
		super(r,g,b);
		this.a = 255;
	}
	
	public Color(int r, int g, int b, int a) {
		super(r,g,b);
		this.a = a;
	}

	public int getColorInt() {
		return (a << 24) | ((int) vec[0] << 16) | ((int) vec[1] << 8) | (int) vec[2];
	}
	
	public static Color getRandomColor(){
		Random rand = new Random();
		return new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
	}

}
