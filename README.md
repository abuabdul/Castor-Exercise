Castor is an XML data binding framework, and useful in many applications that employ xmls to manipulate their data. Castor Exercise is intended to serve a purpose of demonstrating how to use Castor in Introspection and Map Mode. This code base contains source code that is wrapped around actual Castor API classes, and provides easy way to utilize the Castor API.

Castor Exercise API has two interfaces, ICastor and IMapMode. Implementation of these interfaces can utilize Castor API for introspection as well as map mode. There is an abstract behavior called 'introspect' which takes two arguments of type, Object. The applications that extend this Castor Exercise API should give concrete implementation by passing their own objects that they want to serialize into XML or deserialize into object.

To demonstrate the Castor Exercise API, there is a package called 'app' which contains classes that perform introspection and map mode serialization of objects into XML and vice versa. The app package classes use Exercise as their model object to convert from object into XML and XML into an object.



