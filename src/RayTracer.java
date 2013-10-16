import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RayTracer {
	
	private static int WIDTH;
	private static int HEIGHT;

	private BufferedImage image;
	private int[] pixels;

	public RayTracer(int width, int height) {

		long start = System.currentTimeMillis();

		WIDTH = width;
		HEIGHT = height;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		/*
		Random rand = new Random();
		
		for(int i=0;i<HEIGHT;i++){
			for(int j=0;j<WIDTH;j++){
				Color c = new Color(0,i,j);
				pixels[j+i*WIDTH] = c.getColorInt(); 
			}
		}
		*/
			
		Scene scene = new Scene();
		Camera cam = new Camera();
		
		
		Material groundMat = new Material();
		groundMat.aI = 0.2;
		groundMat.aC = new Vec3(128, 128, 128);
		groundMat.dI = 1;
		groundMat.dC = new Vec3(200, 200, 200);
		groundMat.sI = 0.4;
		groundMat.sC = new Vec3(255, 255, 255);
		groundMat.sExp = 10;
		groundMat.reflection = 0.2;

		Material greenMat = new Material();
		greenMat.aI = 0.4;
		greenMat.aC = new Vec3(100, 100, 100);
		greenMat.dI = 1;
		greenMat.dC = new Vec3(100, 200, 100);
		greenMat.sI = 0.5;
		greenMat.sC = new Vec3(0, 255, 0);
		greenMat.sExp = 20;
		greenMat.reflection = 0.2;

		Material blueMat = new Material();
		blueMat.aI = 0.4;
		blueMat.aC = new Vec3(100, 100, 100);
		blueMat.dI = 1;
		blueMat.dC = new Vec3(100, 100, 200);
		blueMat.sI = 0.2;
		blueMat.sC = new Vec3(255, 255, 255);
		blueMat.sExp = 3000;
		blueMat.reflection = 0;
		
		PointLight l = new PointLight(new Vec3(5,5,5));
		Sphere s = new Sphere(new Vec3(0,0,2), 1);
		Sphere s2 = new Sphere(new Vec3(0,0,3), .5);
		Plane p = new Plane(new Vec3(0,-1,0),new Vec3(0,1,0));
		p.material = groundMat;
		s.material = blueMat;
		
		
		scene.addObject(s);
		//scene.addObject(s2);
		scene.addObject(p);
		scene.addLight(l);
		
		for(int y=0;y<HEIGHT;y++){
			for(int x=0;x<WIDTH;x++){
				Ray r = cam.getRay(x,y);
			    setPixelColor(x,y,scene.intersect(r,1));
				//setPixelColor(x,y,new Vec3(0,x,y));

			}
		}
		
		
		try {
			ImageIO.write(image, "png", new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println("Finished in "+((end-start)/1000)+ " seconds");
	}
	
	
	private void setPixelColor(int x,int y, Vec3 c){
		pixels[x+y*WIDTH] = c.getColor();
	}

}
