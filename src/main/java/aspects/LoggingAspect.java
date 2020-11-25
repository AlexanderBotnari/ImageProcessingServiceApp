package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(void transform(String ))")
	public void logBeforeProcessing(JoinPoint jp) {
		Object[] signatureArgs = jp.getArgs();
		   for (Object signatureArg: signatureArgs) {
		      System.out.println("Processing File Name : " + signatureArg);
		   }
	}
	
	@After(value = "execution(void transform(String))")
	public void logAfterProcessing() {
		System.out.println("Processing finished successfully!");
	}
	
}
