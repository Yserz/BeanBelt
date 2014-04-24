package de.beanbelt.bbpassingpropertieswithmaven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Koppen
 */
@Stateless
public class OurService {

	public void readProperties() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream stream = classLoader.getResourceAsStream("filtered_resource.properties");

		Properties properties = new Properties();
		properties.load(stream);

		String value = properties.getProperty("filtered_value", "not_filtered");

		System.out.println("Value: " + value);
	}
}
