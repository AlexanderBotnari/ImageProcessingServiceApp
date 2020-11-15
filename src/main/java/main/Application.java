package main;

import java.io.File;
import java.io.IOException;

import behavior.DirectoryObserver;
import config.ConfigurationProvider;
import processors.ImageProcessor;

public class Application {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting!!!");
		
		DirectoryObserver directoryObserver = new DirectoryObserver(
				new ConfigurationProvider());
				
	    directoryObserver.addFileProcessor(".jpg", new ImageProcessor());
		directoryObserver.observe();
		
//		ImageProcessor ip = new ImageProcessor(new ConfigurationProvider());
//		ip.transform("1.jpg");
		
        System.out.println("Finished!");
		

}
}