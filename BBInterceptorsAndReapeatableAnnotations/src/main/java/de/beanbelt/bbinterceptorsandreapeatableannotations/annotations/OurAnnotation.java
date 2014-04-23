package de.beanbelt.bbinterceptorsandreapeatableannotations.annotations;

import java.lang.annotation.*;
import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Michael Koppen
 */
@Inherited
@Repeatable(OurAnnotations.class)
@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OurAnnotation {

	@Nonbinding
	boolean someValue() default false;
}
