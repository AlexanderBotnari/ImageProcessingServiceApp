package aspects;


public aspect BenchmarkAspect {

//	pointcut whenTransformMethodCalled():call(public void transform(String) );
//	
//	private long lastTime;
//
//	before():whenTransformMethodCalled(){
//		lastTime = System.nanoTime();
//		System.out.println("Processing Started >>> "+lastTime+" nSecs ");
//		System.out.println("Memory used before >>> "+
//		   (Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory())/1024+" KB");
//	}
//	
//	after():whenTransformMethodCalled(){
//		long duration = System.nanoTime()-lastTime;
//		System.out.println("File Processed >>> duration : "+duration/1000000.0+" mSecs ");
//		System.out.println("Memory used after >>> "+
//		(Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory())/1024+" KB");
//	}
}
