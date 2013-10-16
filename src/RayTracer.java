import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RayTracer {
	
	private static int WIDTH = 255;
	private static int HEIGHT = 255;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public RayTracer() {

		long start = System.currentTimeMillis();
		
		Random rand = new Random();
		
		for(int i=0;i<HEIGHT;i++){
			for(int j=0;j<WIDTH;j++){
				Color c = new Color(0,i,j);
				pixels[j+i*WIDTH] = c.getColorInt(); 
			}
		}
		
		try {
			ImageIO.write(image, "png", new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Scene scene = new Scene();
		
		for(int y=0;y<HEIGHT;y++){
			for(int x=0;x<WIDTH;x++){
				
			}
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println("Finished in "+((end-start)/1000)+ " seconds");
	}
	
	
	private void setPixelColor(int x,int y, Color c){
		pixels[x+y*WIDTH] = c.getColorInt();
	}

}
