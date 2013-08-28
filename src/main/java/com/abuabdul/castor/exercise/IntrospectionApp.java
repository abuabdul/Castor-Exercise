package com.abuabdul.castor.exercise;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author abuabdul
 * 
 */
public class IntrospectionApp {
	// Define a static logger variable so that it references the
	// Logger instance named "IntrospectionApp".
	private static final Logger log = LogManager.getLogger(IntrospectionApp.class.getName());

	public static void main(String[] args) {
		//BasicConfigurator.c
		IntrospectionCastor castor = new IntrospectionCastor();
		Exercise exercise = new Exercise();
		populateObject(exercise);
		// Marshalling an object
		castor.marshalObject(exercise, "./Exercise.xml");
		// Unmarshalling xml to an object
		Exercise exer = (Exercise) castor.unmarshalObject(Exercise.class, "./Exercise.xml");
		introspect(exer, exercise);
	}

	/**
	 * Populates the Exercise object in this method
	 * 
	 * @param exercise
	 * @return exercise
	 */
	public static Exercise populateObject(Exercise exercise) {
		if (exercise == null) {
			exercise = new Exercise();
		}
		exercise.setExerciseId(21);
		exercise.setExerciseName("Instropection Mode");
		exercise.setExerciseDesc("Castor Exercise for Introspection Mode");
		exercise.setExerciseDate(Calendar.getInstance().getTime());

		return exercise;
	}

	/**
	 * Introspect the object unmarshalled from an xml. This is to just assert
	 * the unmarshalling is done correct and Java properties are same.
	 * 
	 * @param obj
	 */
	public static void introspect(Exercise exercise, Exercise originalExer) {

		if (exercise == null) {
			log.debug("UnMarshalling failed");
			return;
		}

		if (21 == exercise.getExerciseId()) {
			log.debug("Exercise id is correct");
		}

		if ("Instropection Mode".equalsIgnoreCase(exercise.getExerciseName())) {
			log.debug("Exercise Name is correct");
		}

		if ("Castor Exercise for Introspection Mode".equalsIgnoreCase(exercise.getExerciseDesc())) {
			log.debug("Exercise Description is correct");
		}

		if (originalExer.getExerciseDate().compareTo(exercise.getExerciseDate()) == 0) {
			log.debug("Exercise Date is correct");
		}

	}
}
