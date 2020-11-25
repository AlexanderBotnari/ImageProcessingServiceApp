package aspects;

public aspect LoggerAspect {

	pointcut whenObserveMethodCalled():call(public void observe(String) );
	
	before():whenObserveMethodCalled(){
		System.out.println("Starting !!!\n"
				+"------------------\n"
				+"File Founds : ");
	}
	
	after():whenObserveMethodCalled(){
		System.out.println("Finished!");
	}
	
	
}
