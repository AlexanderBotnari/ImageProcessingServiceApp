package tools;

public aspect LoggerAspect {

	pointcut whenObserveMethodCalled():call(public void observe() );
	
	before():whenObserveMethodCalled(){
		System.out.println("Starting !!!\n"
				+"------------------\n"
				+"FOUND FILES : ");
	}
	
	after():whenObserveMethodCalled(){
		System.out.println("Finished!");
	}
}
