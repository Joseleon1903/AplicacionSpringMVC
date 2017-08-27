/**
 * 
 */

function validarUsuarioSistema(username, password){
	
	console.log("entrando en metodo validarUsuarioSistema de primera forma con jquery");
	console.log("parametro username: "+ username);
	console.log("parametro password: "+ password);
	var urlUsuarioExitoso = "portal/contenido/envioEmail.html";
	var valido = false;
	$.ajax({  
        type: "GET",  
        url: "http://localhost:8081/AplicacionWebRestHtml/rest/usuario/validarSessionUsuario/"+username+"/"+password,  
        data: "",  
        success: function(resp){ 
		     if (resp.respuesta) {
		    	 erroPagina= false;
				window.location.replace(urlUsuarioExitoso);
				valido= true;
			}
        },  
        error: function(e){  
          alert('Error 500: ' + e);  
        }  
      });
	return valido;
}