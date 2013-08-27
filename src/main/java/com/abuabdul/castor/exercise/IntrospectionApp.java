package com.abuabdul.castor.exercise;

import java.util.Calendar;

import junit.framework.Assert;

/**
 * @author abuabdul
 * 
 */
public class IntrospectionApp {

	public static void main(String[] args) {
		IntrospectionCastor castor = new IntrospectionCastor();
		Exercise exercise = new Exercise();
		populateObject(exercise);
		//Marshalling an object
		castor.marshalObject(exercise, "./Exercise.xml");
		//Unmarshalling xml to an object
		Exercise exer=(Exercise) castor.unmarshalObject(Exercise.class, "./Exercise.xml");
		introspect(exer);
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
		
		if(exercise==null) {
			System.out.println("UnMarshalling failed");
			return;
		}
		
		if(21 == exercise.getExerciseId()) {
			System.out.println("Exercise id is correct");
		}
		
		if("Instropection Mode".equalsIgnoreCase(exercise.getExerciseName())) {
			System.out.println("Exercise Name is correct");
		}
		
		if("Castor Exercise for Introspection Mode".equalsIgnoreCase(exercise.getExerciseDesc())) {
			System.out.println("Exercise Description is correct");
		}
		
		if(originalExer.getExerciseDate().compareTo(exercise.getExerciseDate()) == 0) {
			System.out.println("Exercise Date is correct");
		}
		
	}
}
