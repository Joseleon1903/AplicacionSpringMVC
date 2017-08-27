/**
 * ***************************************************************************
 * ****  Funciones y propiedades básicas de JavaScript                                                                  ****
 * ************************************************************************** 
 *
 */
//valida el carácter que se encuentra en la oracion indicada:
function validaOracion(oracion, letra ) {
	
	var contiene = oracion.indexOf(letra);
	if (contiene => 0 ) {
		alert("la letra se encuentra contenida: "+ contiene);
		return contiene;
	}
	alert("La letra no se encuentra");
}

//length, calcula la longitud de una cadena de texto (el número de caracteres que la forman).
function calcularLongitudOracion(oracion) {
	var longOracion;
	console.log("Entering :calcularLongitudOracion");
	console.log("oracion : "+ oracion);
	longOracion = oracion.lengh;
	alert("LongitudOracion : "+ longOracion);
	console.log("Exiting :calcularLongitudOracion");
	return longOracion;
}

//toUpperCase(), transforma todos los caracteres de la cadena a sus correspondientes caracteres en mayúsculas:
function agrandarLetra(oracion) {
	var UpperOracion;
	console.log("Entering :agrandarLetra");
	console.log("oracion : "+ oracion);
	UpperOracion = oracion.toUpperCase();
	alert("Oracion : "+ UpperOracion);
	console.log("Exiting :agrandarLetra");
	return UpperOracion;
}

//charAt(posicion), obtiene el carácter que se encuentra en la posición indicada:
function optenerLetraPosicion(oracion, pos) {
	var letra;
	console.log("Entering :optenerLetraPosicion");
	console.log("oracion : "+ oracion);
	console.log("letra : "+ pos);
	letra = oracion.charAt(pos);
	alert("Letra : "+ letra);
	console.log("Exiting :optenerLetraPosicion");
	return letra;
}

//lastIndexOf(caracter), calcula la última posición en la que se encuentra el carácter indicado dentro de la cadena de texto.
//Si la cadena no contiene el carácter, la función devuelve el valor -1:
function calcularUltimaPosicionLetra(oracion, letra) {
	var pos;
	console.log("Entering :calcularUltimaPosicionLetra");
	console.log("oracion : "+ oracion);
	console.log("letra : "+ letra);
	pos = oracion.lastIndexOf(pos);
	if (pos == -1) {
		alert("La letra no se encuentra.");
	}else{
		alert("Posicion : "+ pos);
	}
	console.log("Exiting :calcularUltimaPosicionLetra");
	return pos;
}

//substring(inicio, final), extrae una porción de una cadena de texto. El segundo parámetro es opcional.
//Si sólo se indica el parámetro inicio, la función devuelve la parte de 
//la cadena original correspondiente desde esa posición hasta el final.
function calcularPosicionCadena(oracion, inicio, final) {
	var oracionR;
	console.log("Entering :calcularPosicionCadena");
	console.log("oracion : "+ oracion);
	console.log("inicio : "+ inicio);
	console.log("final : "+ final);
	oracionR = oracion.substring(inicio, final);
	alert("Oreacion Resultante: "+oracionR);
	console.log("Exiting :calcularPosicionCadena");
	return oracionR;
}

//split(separador), convierte una cadena de texto en un array de cadenas de texto.
//La función parte la cadena de texto determinando sus trozos a partir del carácter separador indicado
function separarPorCaracter(oracion, separador) {
	var lista;
	console.log("Entering :separarPorCaracter");
	console.log("oracion : "+ oracion);
	console.log("separador : "+ separador);
	lista = oracion.split(separador);
	alert("Lista Resultante: "+lista);
	console.log("Exiting :separarPorCaracter");
	return lista;
}


//3.5.2. Funciones útiles para arrays

//join(separador), es la función contraria a split(). Une todos los elementos de un array para formar una cadena de texto.
//Para unir los elementos se utiliza el carácter separador indicado.
//
function concatenarPorCaracter(array, separador) {
	var oracion; 
	console.log("Entering :concatenarPorCaracter");
	console.log("array : "+ array);
	console.log("separador : "+ separador);
	oracion = array.join(separador);
	alert("oracion: "+oracion);
	console.log("Exiting :concatenarPorCaracter");
	return oracion;
}

//pop(), elimina el último elemento del array y lo devuelve. El array original se modifica y su longitud disminuye en 1 elemento.
function eliminarUltimoElemento(array) {
	var ultimo;
	console.log("Entering :eliminarUltimoElemento");
	console.log("array : "+ array);
	ultimo = array.pop();
	console.log("array: "+array);
	console.log("Ultimo : "+ ultimo);
	console.log("Exiting :eliminarUltimoElemento");
	return ultimo;
}

//push(), añade un elemento al final del array. El array original se modifica y aumenta su longitud en 1 elemento. (También es posible añadir más de un elemento a la vez)
function agregarUltimoElemento(array, elemento) {
	var ultimo;
	console.log("Entering :agregarUltimoElemento");
	console.log("elemento : "+ elemento);
	console.log("array : "+ array);
	array.push(elemento);
	console.log("array: "+array);
	console.log("Exiting :agregarUltimoElemento");
	return array;
}

//shift(), elimina el primer elemento del array y lo devuelve. El array original se ve modificado y su longitud disminuida en 1 elemento.
function eliminarPrimerElemento(array) {
	var primo;
	console.log("Entering :eliminarUltimoElemento");
	console.log("array : "+ array);
	primo = array.shift();
	console.log("array: "+array);
	console.log("primo : "+ primo);
	console.log("Exiting :eliminarUltimoElemento");
	return primo;
}

//unshift(), añade un elemento al principio del array. El array original se modifica y aumenta su longitud en 1 elemento.
//(También es posible añadir más de un elemento a la vez)
function agregarPrimerElemento(array, elemento) {
	console.log("Entering :agregarPrimerElemento");
	console.log("elemento : "+ elemento);
	console.log("array : "+ array);
	array.unshift(elemento);
	console.log("array: "+array);
	console.log("Exiting :agregarPrimerElemento");
	return array;
}

/**
 * 
 * @param formulario
 * @returns
 */
function sumarNumero() {
	console.log("entrando metodo : sumarNumero");
	var valor1, valor2, result;
	valor1 = document.getElementById('valor1');
	valor2 = document.getElementById('valor2');
	console.log("validando valores no nulos");
	console.log("valor1: "+valor1.value);
	console.log("valor2: "+ valor2.value);
	if (valor1 == null || valor1 == undefined || valor1.value == "" ) {
		alert("la  "+valor1.id+" es requerido!! ");
		return;variable
	}
	if (valor2 == null || valor2 == undefined || valor2.value == "") {
		alert("la variable "+valor2.id+" es requerido!! ");
		return;
	}
	console.log("validando valores finished");
	var eleResult = document.getElementById('resultado');
	result = Number.parseInt(valor1.value) +Number.parseInt(valor2.value);
	eleResult.value = result;
	console.log("eleResult.value: "+ eleResult.value);
	console.log("saliendo metodo : sumarNumero");
	document.getElementById('resultado').value = result;
}

/**
 * ***************************************************************************
 * ****  Sentencias break y continue    ****
 * ************************************************************************** 
 *
 */
//Si el programa llega a una instrucción de tipo break;, sale inmediatamente del bucle y continúa ejecutando 
//el resto de instrucciones que se encuentran fuera del bucle for. En el ejemplo anterior,
//se recorren todas las letras de una cadena de texto y cuando se encuentra con la primera letra "a",
//se detiene la ejecución del bucle for.
//La utilidad de break es terminar la ejecución del bucle cuando una variable toma un determinado valor o cuando se cumple alguna condición.

//	El siguiente ejemplo muestra el uso de la sentencia break:
function sentenciaBreak() {
	console.log("entrando en metodo : sentenciaBreak");
	var cadena = "En un lugar de la Mancha de cuyo nombre no quiero acordarme...";
	var letras = cadena.split("");
	var resultado = "";
	for(i in letras) {
	  if(letras[i] == 'a') {
	    break;
	  }
	  else {
	    resultado += letras[i];
	  }
	}
	console.log("resultado: "+resultado);
	console.log("saliendo en metodo : sentenciaBreak");
}

//El siguiente ejemplo muestra el uso de la sentencia continue:

function sentenciaContinue() {
	console.log("entrando en metodo : sentenciaBreak");
	var cadena = "En un lugar de la Mancha de cuyo nombre no quiero acordarme...";
	var letras = cadena.split("");
	var resultado = "";
	for(i in letras) {
	  if(letras[i] == 'a') {
		  continue;
	  }
	  else {
	    resultado += letras[i];
	  }
	}
	console.log("resultado: "+resultado);
	console.log("saliendo en metodo : sentenciaBreak");
}

//El siguiente ejemplo muestra el uso de la sentencia While:
function sentenciaWhile() {
	console.log("entrando en metodo : sentenciaWhile");
	console.log("resultado: "+ resultado);
	console.log("numero: "+ numero);
	var resultado = 0;
	var numero = 100;
	var i = 0;
	while(i <= numero) {
	  resultado += i;
	  i++;
	}
	console.log("resultado: "+resultado);
	console.log("saliendo en metodo : sentenciaWhile");
}

//El siguiente ejemplo muestra el uso de la sentencia do while:
function sentenciaDoWhile() {
	console.log("entrando en metodo : sentenciaDoWhile");
	var resultado = 1;
	var numero = 5;
	 
	do {
	  resultado *= numero;  // resultado = resultado * numero
	  numero--;
	} while(numero > 0);
	 
	console.log("resultado: "+resultado);
	console.log("saliendo en metodo : sentenciaDoWhile");
}

//El siguiente ejemplo muestra el uso de la sentencia switch:
function sentenciaSwitch() {
	console.log("entrando en metodo : sentenciaSwitch");
	var opcion;
	opcion = 3;
	console.log("entrando en el switch");

	switch(opcion) {
	  case 5:
			console.log("entrando en el case de opcion = 5");
	    break;
	  case 8:
			console.log("entrando en el case de opcion = 8");
	    break;
	  case 20:
			console.log("entrando en el case de opcion = 20");
	    break;
	  default:
			console.log("entrando en el case de default");
	    break;
	}
	console.log("saliendo del switch");
	console.log("saliendo en metodo : sentenciaSwitch");
}


/**
 * 5.2. Tipos de nodos 
*
* La especificación completa de DOM define 12 tipos de nodos, aunque las páginas XHTML habituales se pueden manipular manejando solamente cuatro o cinco tipos de nodos:
* • Document, nodo raíz del que derivan todos los demás nodos del árbol.
* • Element, representa cada una de las etiquetas XHTML. Se trata del único nodo que puede contener atributos y el único del que pueden derivar otros nodos.
* • Attr, se define un nodo de este tipo para representar cada uno de los atributos de las etiquetas XHTML, es decir, uno por cada par atributo=valor.
* • Text, nodo que contiene el texto encerrado por una etiqueta XHTML.
* • Comment, representa los comentarios incluidos en la página XHTML.
* 
* Los otros tipos de nodos existentes que no se van a considerar son DocumentType, CDataSection, DocumentFragment, Entity, EntityReference, ProcessingInstruction y Notation.

*/


//Una vez construido automáticamente el árbol completo de nodos DOM, ya es posible utilizar las funciones DOM para acceder de forma directa a cualquier nodo del árbol. 
//
//5.3.1. getElementsByTagName()
//
//La función getElementsByTagName(nombreEtiqueta) obtiene todos los elementos de la página XHTML cuya etiqueta sea igual que el parámetro que se le pasa a la función.
/**
*   var parrafos = document.getElementsByTagName("p");
*   var parrafos = document.getElementsByTagName("p");
*   var primerParrafo = parrafos[0];
*   var enlaces = primerParrafo.getElementsByTagName("a");
*   
*/
//5.3.2. getElementsByName()
//
//La función getElementsByName() es similar a la anterior, pero en este caso se buscan los elementos
//cuyo atributo name sea igual al parámetro proporcionado. En el siguiente ejemplo, se obtiene directamente el único párrafo con el nombre indicado:
/**
* var parrafoEspecial = document.getElementsByName("especial");
*
* <p name="prueba">...</p>
* <p name="especial">...</p>
* <p>...</p>
*
*/
//5.3.3. getElementById()
//
//La función getElementById() es la más utilizada cuando se desarrollan aplicaciones web dinámicas. 
//Se trata de la función preferida para acceder directamente a un nodo y poder leer o modificar sus propiedades.
/**
 * var cabecera = document.getElementById("cabecera");
 *  
 *  <div id="cabecera">
 *  <a href="/" id="logo">...</a>
 *  </div>
 * 
 */

//añadir un párrafo simple al final de una página XHTML
function crearParrafo(texto){
	console.log("entrando en el metodo crearParrafo");
	// Crear nodo de tipo Element
	var parrafo = document.createElement("p");
	// Crear nodo de tipo Text
	var contenido = document.createTextNode(texto);
	// Añadir el nodo Text como hijo del nodo Element
	parrafo.appendChild(contenido);
	// Añadir el nodo Element como hijo de la pagina
	document.body.appendChild(parrafo);	
	console.log("saliendo del metodo crearParrafo");
}

//eliminar un nodo del árbol DOM de la página
function eliminarNodo(idNodo){
	console.log("entrando en el metodo eliminarNodo");
	var parrafo = document.getElementById(idNodo);
	parrafo.parentNode.removeChild(parrafo);
	console.log("saliendo del metodo eliminarNodo");
}

/**
 * <a id="enlace" href="http://www...com">Enlace</a>
 */
//mostra atributo elemento 
function mostraAtributoElementoHref(idNodo){
	console.log("entrando en el metodo mostraAtributoElementoHref");
	var enlace = document.getElementById("enlace");
	alert(enlace.href); 
	console.log("saliendo del metodo mostraAtributoElementoHref");	
}

//Obtener propiedades CSS como los atributos XHTML
function optenerPropriedadCss(){
	console.log("entrando en el metodo optenerPropriedadCss");
	var imagen = document.getElementById("imagen");
	alert(imagen.style.margin);
	console.log("saliendo del metodo optenerPropriedadCss");	
}
//Obtener propiedades compuesta CSS como los atributos XHTML
function optenerPropriedadCompuestaCss(){
	console.log("entrando en el metodo optenerPropriedadCompuestaCss");
	var parrafo = document.getElementById("parrafo");
	alert(parrafo.style.fontWeight);
	console.log("saliendo del metodo optenerPropriedadCompuestaCss");	
}
/********************************************************************************************************************************************************* */
