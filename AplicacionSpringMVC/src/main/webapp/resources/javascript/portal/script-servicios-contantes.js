/**
 * valores constantes para los motivoId 
 */
const InternalServerError = 1604;
const InvalidUserException = 502;
const NotFoundObjectError = 404;
const DatoRequeridoNoProporcionado = 1909;

/**
 * Variables globales 
 */
var motivosSistema = new Array();

/* clase javascript para motivoestado*/
function MotivoEstadoSistema(motivoId, descripcion){
	
	this.motivoId = motivoId;
	this.descripcion = descripcion;
}

/**
 * busca el MotivoEstadoSistema en el array por el motivo 
 * @param motivoId
 * @returns MotivoEstadoSistema
 */
function buscarMotivoPorId(motivoId) {
	var elemento;
	motivosSistema.forEach(function(element) {
		if (element.motivoId == motivoId) {
			elemento= element;
		}
	});
	return elemento;
}

function buscarMotivoEstadoSistema(){
	
	entering('llamando el servicio rest buscarMotivoEstadoSistema..');
	var valido = false;
	$.ajax({  
        type: "GET",  
        url: "http://localhost:8081/AplicacionWebRestHtml/rest/motivoEstado/buscarListaMotivosEstadoSistema",  
        data: "",  
        success: function(resp){  
        
        	for(i=0; i<resp.respuesta.length; i++){
        		motivosSistema.unshift(new MotivoEstadoSistema(resp.respuesta[i]['motivoId'], resp.respuesta[i]['descripcion']));
        	}

        },  
        error: function(e){  
          alert('Error 500: ' + e);  
        }  
      });
	return valido;
}