package de.beanbelt.bbinterceptorsandreapeatableannotations.service;

import de.beanbelt.bbinterceptorsandreapeatableannotations.annotations.OurAnnotation;
import de.beanbelt.bbinterceptorsandreapeatableannotations.annotations.OurAnnotations;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Koppen
 */
@Stateless
public class OurService {

	// Java 8
	@OurAnnotation(someValue = true)
	@OurAnnotation(someValue = false)
	public String getName8(long id) {
		System.out.println("method");
		return "databaseString " + id;
	}

	// Java 7
	@OurAnnotations({
		@OurAnnotation(someValue = true),
		@OurAnnotation(someValue = false)
	})
	public String getName7(long id) {
		System.out.println("method");
		return "databaseString " + id;
	}

}
