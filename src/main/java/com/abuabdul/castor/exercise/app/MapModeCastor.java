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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.abuabdul.castor.exercise.map.AbstractMapMode;
import com.abuabdul.castor.exercise.model.Exercise;

/**
 * This class extends the abstract parent class of Map mode in Castor Exercise API.
 * It provides implementation for introspect behavior.
 * 
 * @author abuabdul
 * 
 */
public class MapModeCastor extends AbstractMapMode {

	// Define a static logger variable so that it references the
	// Logger instance named "MapModeCastor".
	private static final Logger log = LogManager.getLogger(MapModeCastor.class.getName());

	public MapModeCastor() {

	}

	@Override
	public void introspect(Object unmarshalled, Object originalObj) {
		Exercise exercise, originalExer = null;
		if (unmarshalled == null || originalObj == null) {
			log.debug("Objects passed are null");
			return;
		}

		exercise = (Exercise) unmarshalled;
		originalExer = (Exercise) originalObj;

		if (exercise.getExerciseId() == 32) {
			log.debug("Exercise id is correct");
		}

		if ("Mapping Mode".equalsIgnoreCase(exercise.getExerciseName())) {
			log.debug("Exercise Name is correct");
		}

		if ("Castor Exercise for Mapping Mode".equalsIgnoreCase(exercise.getExerciseDesc())) {
			log.debug("Exercise Description is correct");
		}

		if (originalExer.getExerciseDate().compareTo(exercise.getExerciseDate()) == 0) {
			log.debug("Exercise Date is correct");
		}
	}

}
