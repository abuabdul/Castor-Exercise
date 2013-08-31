/*This is free and unencumbered software released into the public domain.
 *
 *Anyone is free to copy, modify, publish, use, compile, sell, or
 *distribute this software, either in source code form or as a compiled
 *binary, for any purpose, commercial or non-commercial, and by any
 *means.
 *
 *In jurisdictions that recognize copyright laws, the author or authors
 *of this software dedicate any and all copyright interest in the
 *software to the public domain. We make this dedication for the benefit
 *of the public at large and to the detriment of our heirs and
 *successors. We intend this dedication to be an overt act of
 *relinquishment in perpetuity of all present and future rights to this
 *software under copyright law.
 *
 *THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 *OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 *ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *OTHER DEALINGS IN THE SOFTWARE.
 *
 *For more information, please refer to <http://unlicense.org/>
 */

package com.abuabdul.castor.exercise.app;

import java.net.URL;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.abuabdul.castor.exercise.exception.CastorXmlException;
import com.abuabdul.castor.exercise.map.IMapMode;
import com.abuabdul.castor.exercise.model.Exercise;

/**
 * This is an example class that demonstrates the use of Castor Exercise API for
 * map mode. 
 * 
 * @author abuabdul
 * 
 */
public class MapModeCastorApp {

	// Define a static logger variable so that it references the
	// Logger instance named "MapModeCastorApp".
	private static final Logger log = LogManager.getLogger(MapModeCastorApp.class.getName());

	public static void main(String[] args) {
		try {
			// Populate Exercise object
			Exercise exercise = new Exercise();
			populateObject(exercise);
			// instance of MapModeCastor
			IMapMode castor = new MapModeCastor();
			// Load mapping xml
			URL mappingUrl = MapModeCastorApp.class.getClassLoader().getResource("ExerciseMapping.xml");
			log.debug("Mapping file path " + mappingUrl.getPath());
			castor.loadMapping(mappingUrl.getPath());
			// Marshalling an object
			castor.marshalObject(exercise, "./ExerciseMappingInstance.xml");
			// Unmarshalling xml to an object
			Exercise exer = (Exercise) castor.unmarshalObject(Exercise.class, "./ExerciseMappingInstance.xml");
			// Introspect the unmarshalled object with original
			castor.introspect(exer, exercise);
		} catch (CastorXmlException cas) {
			log.debug("Castor Xml Exception occurred at MapModeCastorApp");
			log.debug(cas.getMessage());
		} catch (Exception ex) {
			log.debug("Exception occurred at MapModeCastorApp");
			log.debug(ex.getMessage());
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
		exercise.setExerciseId(32);
		exercise.setExerciseName("Mapping Mode");
		exercise.setExerciseDesc("Castor Exercise for Mapping Mode");
		exercise.setExerciseDate(Calendar.getInstance().getTime());
		log.debug("populateObject returns after setting exercise object");
		return exercise;
	}
}
