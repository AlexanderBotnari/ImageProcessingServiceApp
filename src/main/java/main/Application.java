package main;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.twelvemonkeys.image.ResampleOp;

public class Application {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting!!!");
		
		/////////Observer design pattern
		////////target/observable
		
		File rootDir = new File("images/originals");
		//1.
		if (!rootDir.exists() || !rootDir.isDirectory()) {
			System.err.println("Root directory error!");
			return;
		}
				
		///watch loop
		File[] lastFiles = {};
		
		while(true) {
			
			File[] files = rootDir.listFiles(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					String lowerCaseName = name.toLowerCase();
					if(!lowerCaseName.endsWith(".jpeg") && !lowerCaseName.endsWith(".jpg")) {
						return false;
					}else {
					    return true;
					}
				}
			});
			//detect is something has changed
			//2.
			if(!Arrays.equals(lastFiles, files) && files != null ) {
				System.out.println("------------------");
				System.out.println("FOUND FILES : ");
				
				for (File file : files) {
					System.out.println(">> "+file);
					transformImage(file);
				}
				
				lastFiles = files;
			}
			
			Thread.sleep(200);
		}
	}
		//System.out.println("Finished!");
		
		//////////////////////////////////////////////////
		//Transformer/processor
		
		public static void transformImage(File file) throws IOException {
		BufferedImage bio = ImageIO.read(file);
		
		
		BufferedImageOp resampler = new ResampleOp(200,200,ResampleOp.FILTER_LANCZOS);
		BufferedImage bir = resampler.filter(bio, null);
		
		System.out.println("FILE PROCESSED >> "+file.getName());
		ImageIO.write(bir, "jpeg", new File(file.getPath().replace("originals", "processed")));
		
	
        //////////////////////////////////////////////////
	}

}
