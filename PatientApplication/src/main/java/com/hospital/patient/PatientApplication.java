package com.hospital.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Represents a Patient.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.0
 * @since 1.0
*/
@SpringBootApplication
public class PatientApplication {

	/**
	 * Returns void
	 *
	 * @param args - to receive JVM arguments while running the application.
	 * @return - void but creates Spring Application context and deploy application
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);

	}

}
