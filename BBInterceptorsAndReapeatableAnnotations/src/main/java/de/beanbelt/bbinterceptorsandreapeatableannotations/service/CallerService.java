package de.beanbelt.bbinterceptorsandreapeatableannotations.service;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Koppen
 */
@Stateless
public class CallerService {

	@EJB
	OurService ourService;

	/**
	 * Method to call the intercepted method.
	 */
	@Schedule(second = "*/5", minute = "*", hour = "*")
	private void timedCall() {
		System.out.println("Calling intercepted methods...");
		System.out.println("Java7: ");
		System.out.println(ourService.getName7(7));
		System.out.println("Java8: ");
		System.out.println(ourService.getName8(8));
	}
}
