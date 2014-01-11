<h1 id="castor-exercise-api"><a href="#castor-exercise-api" class="anchor">Castor Exercise API</a></h1>

<p>Castor is an XML data binding framework, and useful in many applications that employ xmls to manipulate their data. Castor Exercise is intended to serve a purpose of demonstrating how to use Castor in Introspection and Map Mode. This code base contains source code that is wrapped around actual Castor API classes, and provides easy way to utilize the Castor API.</p>

<p>Castor Exercise API has two interfaces, ICastor and IMapMode. Implementation of these interfaces can utilize Castor API for introspection as well as map mode. There is an abstract behavior called 'introspect' which takes two arguments of type, Object. The applications that extend this Castor Exercise API should give concrete implementation by passing their own objects that they want to serialize into XML or deserialize into object.</p>

<p>To demonstrate the Castor Exercise API, there is a package called 'app' which contains classes that perform introspection and map mode serialization of objects into XML and vice versa. The app package classes use Exercise as their model object to convert from object into XML and XML into an object.</p>

<h2 id="features"><a href="#features" class="anchor">Features</a></h2>

<ul>
<li>Demonstration to convert from Object to XML, vice versa</li>
<li>Demonstration on Introspection and Map modes.</li>
<li>Sample mapping XML file</li>
</ul>


<h2 id="requirements"><a href="#requirements" class="anchor">Requirements</a></h2>

<ul>
<li>Eclipse IDE</li>
<li>Java 1.6 or higher</li>
<li>Eclipse Maven plugin</li>
</ul>


<h2 id="install"><a href="#install" class="anchor">Install</a></h2>

<p>Just clone the repo:</p>

<pre class="no-highlight">$ git clone https://github.com/abuabdul/Castor-Exercise.git</pre>


<p>And install eclipse maven plugin</p>

<pre class="no-highlight">run pom.xml</pre>


<h2 id="contribute"><a href="#contribute" class="anchor">Contribute</a></h2>

<p>You can contribute to this project.</p>

<ul>
<li>Add more features</li>
<li>Customize it to play with Castor</li>
</ul>


<h2 id="license"><a href="#license" class="anchor">License</a></h2>

<p>This is free and unencumbered software released into the public domain.</p>

<p>Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.</p>

<p>In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.</p>

<p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.</p>

<p>For more information, please refer to <a href="http://unlicense.org/">http://unlicense.org/</a></p>
