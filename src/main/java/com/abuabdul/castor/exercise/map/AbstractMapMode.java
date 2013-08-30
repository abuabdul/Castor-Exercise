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

package com.abuabdul.castor.exercise.map;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import com.abuabdul.castor.exercise.AbstractCastor;
import com.abuabdul.castor.exercise.exception.CastorXmlException;

/**
 * @author abuabdul
 * 
 */
public abstract class AbstractMapMode extends AbstractCastor implements IMapMode {

	// Define a static logger variable so that it references the
	// Logger instance named "AbstractMapCastor".
	private static final Logger log = LogManager.getLogger(AbstractMapMode.class.getName());

	protected XMLContext context = null;

	public XMLContext loadMapping(String mappingXml) throws CastorXmlException {
		try {
			Mapping mapping = new Mapping();
			mapping.loadMapping(mappingXml);
			context = new XMLContext();
			context.addMapping(mapping);
		} catch (IOException e) {
			log.debug("IO Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} catch (MappingException e) {
			log.debug("Mapping File Exception occurred");
			throw new CastorXmlException(e.getMessage());
		}
		return context;
	}

	@Override
	public void marshalObject(Object obj, String xmlPath) throws CastorXmlException {
		Marshaller marshaller = null;
		try {
			writer = new FileWriter(xmlPath);
			marshaller = this.getXMLContext().createMarshaller();
			marshaller.setWriter(writer);
			marshaller.marshal(obj);
			writer.close();
		} catch (CastorXmlException e) {
			log.debug("Exception occurred while loading mapping xml");
			throw new CastorXmlException(e.getMessage());
		} catch (MarshalException e) {
			log.debug("Marshalling Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} catch (ValidationException e) {
			log.debug("Validation Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} catch (IOException e) {
			log.debug("IO Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} finally {
			writer = null;
		}
	}

	@Override
	public <T> Object unmarshalObject(Class<T> clazz, String xmlPath) throws CastorXmlException {
		Object obj = null;
		Unmarshaller unmarshaller = null;
		try {
			reader = new FileReader(xmlPath);
			unmarshaller = this.getXMLContext().createUnmarshaller();
			unmarshaller.setClass(clazz);
			obj = unmarshaller.unmarshal(reader);
		} catch (CastorXmlException e) {
			log.debug("Exception occurred while loading mapping xml");
			throw new CastorXmlException(e.getMessage());
		} catch (MarshalException e) {
			log.debug("Marshalling Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} catch (ValidationException e) {
			log.debug("Validation Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} catch (IOException e) {
			log.debug("IO Exception occurred");
			throw new CastorXmlException(e.getMessage());
		} finally {
			reader = null;
		}
		return obj;
	}

	public abstract void introspect(Object unmarshalled, Object originalObj);

	/**
	 * Returns the context after checking for nullability
	 * 
	 * @return XMLContext
	 * @throws CastorXmlException
	 */
	private XMLContext getXMLContext() throws CastorXmlException {
		if (context == null) {
			log.debug("XMLContext object is null");
			throw new CastorXmlException("Cannot get XMLContext instance. Load mapping xml first before marshalling/unmarshalling");
		}
		return context;
	}
}
