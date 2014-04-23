package de.beanbelt.bbinterceptorsandreapeatableannotations.interceptors;

import de.beanbelt.bbinterceptorsandreapeatableannotations.annotations.OurAnnotation;
import java.lang.reflect.Method;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Michael Koppen
 */
@OurAnnotation
@javax.interceptor.Interceptor
public class OurInterceptor {

	@javax.interceptor.AroundInvoke
	public Object someMethodName(InvocationContext context) throws Exception {
		Method method = context.getMethod();
		if (method.isAnnotationPresent(OurAnnotation.class)) {
			boolean someValue = method.getAnnotation(OurAnnotation.class).someValue();
			System.out.println("someValue is: " + someValue);
		}
		// do something before method
		System.out.println(">before");

		//executing source method
		Object result = context.proceed();

		// do something after method
		System.out.println("<after");

		return result;
	}
}
