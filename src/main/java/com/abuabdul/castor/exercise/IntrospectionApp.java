package com.abuabdul.castor.exercise;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.abuabdul.castor.exercise.exception.CastorXmlException;
import com.abuabdul.castor.exercise.model.Exercise;

/**
 * @author abuabdul
 * 
 */
public class IntrospectionApp {

	// Define a static logger variable so that it references the
	// Logger instance named "IntrospectionApp".
	private static final Logger log = LogManager.getLogger(IntrospectionApp.class.getName());

	public static void main(String[] args) {
		try {
			// instance of IntrospectionCastor
			ICastor castor = new IntrospectionCastor();
			// Exercise object
			Exercise exercise = new Exercise();
			populateObject(exercise);
			// Marshalling an object
			castor.marshalObject(exercise, "./Exercise.xml");
			// Unmarshalling xml to an object
			Exercise exer = (Exercise) castor.unmarshalObject(Exercise.class, "./Exercise.xml");
			// Introspect the unmarshalled object with original
			castor.introspect(exer, exercise);
		} catch (CastorXmlException cas) {
			log.debug("Exception occurred at Instropection App");
			log.debug(cas.getMessage());
		}
	}

	/**
	 * Populates the Exercise object in this method
	 * 
	 * @param exercise
	 * @return exercise
	 */
	public static Exercise populateObject(Exercise exercise) {
		log.debug("populateObject is invoked");
		if (exercise == null) {
			exercise = new Exercise();
		}
		exercise.setExerciseId(21);
		exercise.setExerciseName("Instropection Mode");
		exercise.setExerciseDesc("Castor Exercise for Introspection Mode");
		exercise.setExerciseDate(Calendar.getInstance().getTime());
		log.debug("populateObject returns after setting exercise object");
		return exercise;
	}
}
