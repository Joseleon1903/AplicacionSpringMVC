/**
 * valores constantes para los motivoId 
 */
const InternalServerError = 1604;
const InvalidUserException = 502;
const NotFoundObjectError = 404;
const DatoRequeridoNoProporcionadoCod = 1909;
const DatoRequeridoNoProporcionadoDesc = "[NOT FOUND  OBJECT] Existen datos requeridos no porporcionados";

/**
 * Variables globales 
 */
var motivosSistema = new Array();

/* clase javascript para motivoestado*/
function MotivoEstadoSistema(motivoId, descripcion){
	
	this.motivoId = motivoId;
	this.descripcion = descripcion;
}