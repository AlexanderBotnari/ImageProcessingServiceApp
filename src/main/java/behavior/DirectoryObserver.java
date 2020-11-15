package behavior;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import config.ConfigurationProvider;
import processors.ImageProcessor;

public class DirectoryObserver {

	private ConfigurationProvider cp;
	private HashMap<String,ImageProcessor> processors;
	
	public DirectoryObserver(ConfigurationProvider cp) {
         this.cp = cp;
         processors = new HashMap<>();         
	}
	
	public void addFileProcessor(String extension, ImageProcessor ip) {
		ip.setConfigurationProvider(cp);
		processors.put(extension, ip);
	}
	
	public void observe() throws InterruptedException, IOException {
		
		File rootDir = new File(cp.get("path.originals"));
		if (!rootDir.exists() || !rootDir.isDirectory()) {
			System.err.println("Root directory error!");
			return;
		}
		
		File[] lastFiles = {};
		
		while(true) {
			File[] files = rootDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					String lowerCaseName = name.toLowerCase();
					if((!lowerCaseName.endsWith(".jpeg") && !lowerCaseName.endsWith(".jpg"))) {
						return false;
					}else {
					    return true;
					}
				}
			});
			if(!Arrays.equals(lastFiles, files) && files != null ) {
				System.out.println("------------------");
				System.out.println("FOUND FILES : ");
				
				for (File file : files) {
					if(!file.isDirectory()) {
					System.out.println(">> "+file);
					processors.get(".jpg").transform(file.getName());
					}
				}
				
				lastFiles = files;
			}
			
			Thread.sleep(200);
		}
	}
	}
