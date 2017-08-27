/**
 * Curso JavaScript desde 0. Sintaxis Básica V Arrays, Matrices, Arreglos. Vídeo 7
 * 
 * metodos de los array en javascript 
 * 
 * 1) length
 * 2) push agrega un elemento
 * 3) unshift agrega un elemento al principio
 * 4) pop elimina elemento  final 
 * 5) shift elimina elemento inicial
 * 
 */
 var articulos =  [ "camisa", "pantalon", "zapato", "calzetines" ]
 
 
 
function llamandoRest(){
	 alert("entrando metodo llamandoRest");
	 $(document).ready(function() {
		    $.ajax({
		        url: "http://localhost:8081/AplicacionWebRestHtml/rest/usuario/buscarUsuarioPorCodigo/ADMIN"
		    }).then(function(data) {
		      alert("date "+ data.contacto);
		    });
		});
	 
 }