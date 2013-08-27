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

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * @author abuabdul
 * 
 */
public class IntrospectionCastor implements ICastor {
	private Writer writer = null;
	private Reader reader = null;

	public IntrospectionCastor() {

	}

	public void marshalObject(Object obj, String xmlPath) {
		try {
			writer = new FileWriter(xmlPath);
			Marshaller.marshal(obj, writer);
			writer.close();
		} catch (MarshalException e) {
			System.out.println(e.getMessage());
			System.out.println("Marshalling Exception occurred");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			System.out.println("Validation Exception occurred");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("IO Exception occurred");
		} finally {
			writer = null;
		}
	}

	public <T> Object unmarshalObject(Class<T> clazz, String xmlPath) {
		Object obj = null;
		try {
			reader = new FileReader(xmlPath);
			obj = Unmarshaller.unmarshal(clazz, reader);
		} catch (MarshalException e) {
			System.out.println(e.getMessage());
			System.out.println("Marshalling Exception occurred");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			System.out.println("Validation Exception occurred");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("IO Exception occurred");
		} finally {
			reader = null;
		}
		return obj;
	}

}
