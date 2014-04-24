package de.beanbelt.bbpassingpropertieswithmaven;

import java.io.IOException;
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
	private void timedCall() throws IOException {
		System.out.println("Reading properties...");
		ourService.readProperties();

	}
}
