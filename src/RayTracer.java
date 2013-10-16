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
		
		Sphere s = new Sphere(new Vec3(0,0,0), 3);
		scene.addObject(s);
		
		Plane p = new Plane(new Vec3(0,-1,0),new Vec3(0,1,0));
		scene.addObject(p);
		
		for(int y=0;y<HEIGHT;y++){
			for(int x=0;x<WIDTH;x++){
				Ray r = cam.getRay(x,y);
			    setPixelColor(x,y,scene.intersect(r));
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
	
	
	private void setPixelColor(int x,int y, Color c){
		pixels[x+y*WIDTH] = c.getColorInt();
	}

}
