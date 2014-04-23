/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beanbelt.bbinterceptorsandreapeatableannotations.interceptors;

import de.beanbelt.bbinterceptorsandreapeatableannotations.annotations.OurAnnotation;
import de.beanbelt.bbinterceptorsandreapeatableannotations.annotations.OurAnnotations;
import java.lang.reflect.Method;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Michael Koppen
 */
@OurAnnotations(
	@OurAnnotation
)
@javax.interceptor.Interceptor
public class OurGroupingInterceptor {

	@javax.interceptor.AroundInvoke
	public Object someMethodName(InvocationContext context) throws Exception {
		Method method = context.getMethod();
		if (method.isAnnotationPresent(OurAnnotations.class)) {
			OurAnnotation[] ourAnnotations = method.getAnnotation(OurAnnotations.class).value();
			for (OurAnnotation annotation : ourAnnotations) {
				System.out.println("someValue is: " + annotation.someValue());
			}
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
