package com.abuabdul.castor.exercise;

import java.util.Calendar;

/**
 * @author abuabdul
 * 
 */
public class IntrospectionApp {

	public static void main(String[] args) {
		IntrospectionCastor castor = new IntrospectionCastor();
		Exercise exercise = new Exercise();
		populateObject(exercise);
		castor.marshalObject(exercise, "./Exercise.xml");
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
