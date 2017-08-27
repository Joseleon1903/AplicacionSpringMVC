/**
 *Java script y tipos de datos
 *1- String
 *2- numerico
 *3- booleanos
 * 
 */

//declarando variables javaScript
var nombre = "Mario";
var puntuacion = 0;
var record;
record = 500;

//alert(nombre);
//alert(puntuacion);
//alert(record);

/**  
 *  operadores matematicos con javascript... 
 * 
 * */ 
var h4 = "<h4>", h4c = "</h4>";
var parra = "<p>", parrac = "</p>";

var numero1 , numero2,numero3, resultado;

document.write(h4+ "Sumando don numero 25 +50... "+ h4c)
numero1 = 25;
numero2 = 50;
resultado = numero1+ numero2;

document.write(parra+ "Resultado : "+resultado+parrac);

//-------------------------------------------------------------------------------------
document.write(h4+ "Restando dos numero 85 - 13... "+ h4c)
numero1 = 85;
numero2 = 13;
resultado = numero1- numero2;

document.write(parra+ "Resultado : "+resultado+parrac);

//-------------------------------------------------------------------------------------
document.write(h4+ "multiplicando dos numero 8 * 3 ... "+ h4c)
numero1 = 8;
numero2 = 3;
resultado = numero1 * numero2;

document.write(parra+ "Resultado : "+resultado+parrac);

//-------------------------------------------------------------------------------------

document.write(h4+ "Dicidiendo dos numero 365 / 12 ... "+ h4c)
numero1 = 365;
numero2 = 12;
resultado = numero1 / numero2;

document.write(parra+ "Resultado : "+resultado+parrac);

//-------------------------------------------------------------------------------------

document.write(h4+ "Orden de los operadores 5+6*3 ... "+ h4c)
numero1 = 5;
numero2 = 6;
numero3 = 3;
resultado = numero1 + numero2 * numero3;

document.write(parra+ "Resultado : "+resultado+parrac);
//-------------------------------------------------------------------------------------





