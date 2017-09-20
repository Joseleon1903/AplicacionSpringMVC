package com.aplicacion.spring.mvc.vista.beans;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.exception.DatoRequeridoNoProporcionadoException;
import com.aplication.spring.mvc.exception.DuplicateObjectException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.InvalidDataException;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Component
public class ManejadorRegistrarUsuarioBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorRegistrarUsuarioBean.class);
	
	@Resource(mappedName = "java:global/AplicacionSpringMVC/UsuarioEjbImpl!com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl")
	private UsuarioEjbImpl usuarioES;
	
	@Resource(mappedName = "java:global/AplicacionSpringMVC/MotivoEstadoEjbImpl!com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl")
	private MotivoEstadoEjbImpl motivoEstadoEJB;

	public ManejadorRegistrarUsuarioBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String validarNuevoUsuario(RegistrarUsuarioBean nuevoUsuario){
		logger.info("Loguenado parametros de entrada..");
		logger.info("nombre: "+ nuevoUsuario.getNombre());
		logger.info("Apellido: "+ nuevoUsuario.getApellido());
		logger.info("Sexo: "+ nuevoUsuario.getSexo());
		logger.info("FechaNacimiento: "+ nuevoUsuario.getFechaNacimineto());
		logger.info("Email: "+ nuevoUsuario.getEmail());
		logger.info("Username: "+ nuevoUsuario.getUsername());
		logger.info("Password 1: "+ nuevoUsuario.getPassword());
		logger.info("Password 2: "+ nuevoUsuario.getConfirmarPassword());
		logger.info("EmailAlternativa: "+ nuevoUsuario.getEmailAlternativa());
		logger.info("Direccion: "+ nuevoUsuario.getDireccion());
		logger.info("Telefono: "+ nuevoUsuario.getTelefono());
		logger.info("Celular: "+ nuevoUsuario.getCelular());
		//terminando loguear parametros usuario..
		
		return "rediret:/views/portal/pagina/RegistrarUsuario";
	}
	
	/**
	 * Descripcion: metodo para validar los datos requeridos del Formulario.
	 * 
	 * @param nuevoUsuario
	 * @throws DatoRequeridoNoProporcionadoException
	 */
	public void validarDatosRequeridos(RegistrarUsuarioBean nuevoUsuario) throws DatoRequeridoNoProporcionadoException{
		logger.info("entrando en el metodo validarDatosRequeridos");
		logger.info("iniciando validaciones de los datos requeridos");
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getNombre())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getApellido())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getSexo())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getEmail())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getUsername())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getPassword())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getConfirmarPassword())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		if (ValidationUtil.isObjectNotNull(nuevoUsuario.getFechaNacimineto())) {
			throw new DatoRequeridoNoProporcionadoException();
		}
		logger.info("Saliendo del metodo validarDatosRequeridos");
		logger.info("Finalizando validaciones de los datos requeridos");

	}
	
	/**
	 *  Descripcion: metodo para validar iguald de las password proporcionadas.
	 * 
	 * @param password1
	 * @param password2
	 * @throws InvalidDataException
	 */
	public void validarIncidenciaPassword(String password1, String password2) throws InvalidDataException{
		logger.info("entrando en el metodo validarIncidenciaPassword");
		logger.info("iniciando validaciones password proporcionadas");
		if (!password1.equals(password2)) {
			throw new InvalidDataException();
		}
		logger.info("Saliendo del metodo validarIncidenciaPassword");
		logger.info("Finalizando validaciones password");
	}
	
	public void validarUsernameDuplicado(String nombreUsuario) throws DuplicateObjectException{
		logger.info("entrando en el metodo validarUsernameDuplicado");
		logger.info("iniciando validaciones Username Usuario proporcionadas");
		UsuarioType usuario= null;
		try {
			 usuario = usuarioES.buscarUsuarioPorCodigo(nombreUsuario);
		} catch (InternalServiceException e) {
			logger.debug("Error buscando el usuario por el codigo..");
			logger.info("ERRROR: "+ e.getMessage());
		}
		logger.info("Terminando de buscar usuario con las credenciales proporcionadas..");
		if (!ValidationUtil.isObjectNotNull(usuario)) {
			throw new DuplicateObjectException(DuplicateObjectException.CODIGO, DuplicateObjectException.DESCRIPCION);
		}
		logger.info("Saliendo del metodo validarUsernameDuplicado");
		logger.info("Finalizando validaciones Username Usuario");
	}

}
