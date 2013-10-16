public class Color {

	private int a, r, g, b;

	public Color() {
		this.a = 255;
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}
	
	public Color(int r, int g, int b) {
		this.a = 255;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color(int r, int g, int b, int a) {
		this.a = a;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getColorInt() {
		return (a << 24) | (r << 16) | (g << 8) | b;
	}

}
