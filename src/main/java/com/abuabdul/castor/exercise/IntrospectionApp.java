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
		castor.introspect(exer, exercise);
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
}
