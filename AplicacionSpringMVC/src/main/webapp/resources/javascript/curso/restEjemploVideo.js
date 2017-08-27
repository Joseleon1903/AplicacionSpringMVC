/**
 * 
 */

function llamandoRest(){
	console.log("entrando en metodo llamandoRest de primera forma con jquery");
	
	$.getJSON('http://localhost:8081/AplicacionWebRestHtml/rest/usuario/SayHello', function(data) {

		console.log("Imprimiendo resultado");
		console.log("contacto: "+ data.contacto);
		console.log("nombre: "+ data.nombre);
		console.log("usuario: "+ data.usuario);
	
		});
	
	
	console.log("entrando en metodo llamandoRest de segunda forma con ajax");
	$.ajax({  
        type: "GET",  
        url: "http://localhost:8081/AplicacionWebRestHtml/rest/usuario/SayHello",  
        data: "",  
        success: function(resp){  
          // we have the response  
        	console.log("Imprimiendo resultado");
    		console.log("contacto: "+ resp.contacto);
    		console.log("nombre: "+ resp.nombre);
    		console.log("usuario: "+ resp.usuario); 
        },  
        error: function(e){  
          alert('Error121212: ' + e);  
        }  
      });
	
}