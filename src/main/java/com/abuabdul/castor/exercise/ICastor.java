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

package com.abuabdul.castor.exercise;

/**
 * @author abuabdul
 * 
 */
public interface ICastor {

	/**
	 * Marshal any Java Object into an xml mentioned in the xml path.
	 * 
	 * @param obj
	 * @param xmlPath
	 */
	public void marshalObject(Object obj, String xmlPath);

	/**
	 * UnMarshal any xml mentioned in the xml path into a Java Object
	 * 
	 * @param clazz
	 * @param xmlPath
	 * @return
	 */
	public <T> Object unmarshalObject(Class<T> clazz, String xmlPath);

	/**
	 * Introspect the object unmarshalled from an xml. This is to just assert
	 * the unmarshalling is done correct and Java properties are same.
	 * 
	 * @param obj
	 */
	public void introspect(Object obj);

}
