/**
 * 
 */
const PaginaHome = "/views/portal/pagina/Home";
const PaginaActualizarContacto = "/views/portal/pagina/ActualizarContacto";
const PaginaEnviarEmail = "/views/portal/pagina/EnviarEmail";
const PaginaListaEmailEnviadas = "/views/portal/pagina/ListaEmailEnviadas";
const PaginaRegistrarUsuario = "/views/portal/pagina/RegistrarUsuario";
const PaginaLogoutUsuario = "/views/portal/pagina/logout";

function redirigirLink(Urlpagina){
	entering('entrando en el metodo redirigirLink para cargar la pagina..');
	parametro('Pagina URL ', Urlpagina);
	window.location="http://localhost:8081/AplicacionSpringMVC"+ Urlpagina;	
	exiting('saliendo en el metodo redirigirLink para cargar la pagina..');
}