package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceBenchmarkAspect {
	
	@Around("execution(void transform(String))")
	public Object measureProcessingPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		    final long startTime = System.nanoTime();
        
            Object returnedValue = joinPoint.proceed();
            System.out.println("Benchmarked method : "+joinPoint.getSignature().getName()+"()"+
                    " from class >>> "+
            		joinPoint.getTarget().getClass().getCanonicalName());
            
            final long duration = System.nanoTime()-startTime;
            System.out.println("Elapsed Time : "+duration/1000000.0+" mSecs");
            return returnedValue;
       
    }
	
}
