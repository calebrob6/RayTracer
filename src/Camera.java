public class Camera {

	private Vec3 e;
	private double distance;
	private int top, right, bottom, left;
	private Vec3 w, u, v;
	private int nx, ny;
	private int f;

	public Camera() {
		this.e = new Vec3(0, 5, 10);
		this.distance = 2;
		this.top = 2;
		this.right = 2;
		this.bottom = -this.top;
		this.left = -this.right;
		this.w = new Vec3(0, 0, -1);
		this.w = this.w.norm();
		this.u = new Vec3(1, 0, 0);
		this.u = this.u.norm();
		this.v = this.w.cross(this.u);
		this.nx = 512;
		this.ny = 512;
		this.f = 1;
	}

	public Ray getRay(int x, int y) {
		double uu = this.left + (this.right - this.left) * (x + 0.5d) / this.nx;
		double vv = this.bottom + (this.top - this.bottom) * (y + 0.5d) / this.ny;
		Vec3 d = this.w.scalarMultiply(-this.distance).add(this.u.scalarMultiply(uu)).add(this.v.scalarMultiply(vv));
		Vec3 e = this.e;
		return new Ray(d, e);
	}
}
