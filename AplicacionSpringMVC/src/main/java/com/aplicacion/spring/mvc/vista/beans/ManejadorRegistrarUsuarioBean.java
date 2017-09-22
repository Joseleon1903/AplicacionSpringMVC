package com.aplicacion.spring.mvc.vista.beans;

import java.util.Date;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstante;
import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.exception.DatoRequeridoNoProporcionadoException;
import com.aplication.spring.mvc.exception.DuplicateObjectException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.InvalidDataException;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Component
public class ManejadorRegistrarUsuarioBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorRegistrarUsuarioBean.class);
	
	@Resource(mappedName = "java:global/AplicacionSpringMVC/UsuarioEjbImpl!com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl")
	private UsuarioEjbImpl usuarioES;
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorUtil;
	
	public ManejadorRegistrarUsuarioBean() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean validarNuevoUsuario(RegistrarUsuarioBean nuevoUsuario, UsuarioSession sessionUsuario){
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
		logger.info("sessionUsuario: "+sessionUsuario);
		//terminando loguear parametros usuario..
		try {
			logger.info("Inciando validacion valores requeridos..");
			validarDatosRequeridos(nuevoUsuario);
		} catch (DatoRequeridoNoProporcionadoException e) {
			sessionUsuario.setError(true);
			MotivoEstadoType motivo = manejadorUtil.buscarMotivoPorId(ParametrosErrorConstante.DATOS_REQUERIDO_ERROR_COD);
			sessionUsuario.setMensajeError(motivo.getDescripcion());
			return false;
		}
		logger.info("Finalizando validacion valores requeridos EXITOSA..");
		try {
			logger.info("Inciando validacion PASSWORD..");
			validarIncidenciaPassword(nuevoUsuario.getPassword(), nuevoUsuario.getConfirmarPassword());
		} catch (InvalidDataException e) {
			sessionUsuario.setError(true);
			MotivoEstadoType motivo = manejadorUtil.buscarMotivoPorId(ParametrosErrorConstante.INCIDENCIA_PASSWORD_ERROR_COD);
			sessionUsuario.setMensajeError(motivo.getDescripcion());
			return false;
		}
		logger.info("finalizando validacion PASSWORD EXITOSA..");
		try {
			logger.info("Iniciando validacion nombre usuario..");
			validarUsernameDuplicado(nuevoUsuario.getUsername());
		} catch (DuplicateObjectException e) {
			sessionUsuario.setError(true);
			MotivoEstadoType motivo = manejadorUtil.buscarMotivoPorId(ParametrosErrorConstante.USERNAME_DUPLICADO_ERROR_COD);
			sessionUsuario.setMensajeError(motivo.getDescripcion());
			return false;
		}
		logger.info("Finalizando validacion nombre usuario EXITOSA..");
		logger.info("Finalizando validacion nuevo usuario EXITOSA..");
		return true;
	}
	
	public String registrarNuevoUsuario(RegistrarUsuarioBean nuevoUsuario,UsuarioSession sessionUsuario){
		logger.info("Entrando en el metodo registrarNuevoUsuario");
		//setando datos usuario
		UsuarioType userType = new UsuarioType();
		userType.setCodigoUsuario(nuevoUsuario.getUsername());
		userType.setPassword(nuevoUsuario.getPassword());
		userType.setFechaCreacion(new Date());
		userType.setFechaUltimoAcceso(new Date());
		//seteando datos contacto
		ContactoType contactoType=  new ContactoType();
		contactoType.setNombre(nuevoUsuario.getNombre());
		contactoType.setApellido(nuevoUsuario.getApellido());
		contactoType.setFechaNacimineto(nuevoUsuario.getFechaNacimineto());
		contactoType.setEmail(nuevoUsuario.getEmail());
		contactoType.setSexo(nuevoUsuario.getSexo());
		contactoType.setEstado("AC");
		//seteando datos detalle contacto
		if (!ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getEmailAlternativa()) ||
				!ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getCelular())  ||
				!ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getTelefono()) ||
				!ValidationUtil.isStringNotNullOrEmpty(nuevoUsuario.getDireccion())) {
			DetalleContactoType detalleType = new DetalleContactoType();
			detalleType.setCorreoAlterno(nuevoUsuario.getEmailAlternativa());
			detalleType.setTelefono(nuevoUsuario.getTelefono());
			detalleType.setCelular(nuevoUsuario.getCelular());
			detalleType.setDireccion(nuevoUsuario.getDireccion());
			contactoType.setDetalleContactoId(detalleType);
		}
		//completando datos usuario
		userType.setContacto(contactoType);
		logger.info("Usuario a registrar "+ userType);
		logger.info("Contacto a registrar "+ userType.getContacto());
		logger.info("Detalle Contacto a registrar: "+ userType.getContacto().getDetalleContactoId());
		logger.info("Iniciando registracion usuario");
		boolean registrado = false;
		try {
			registrado = usuarioES.registrarNuevoUsuarioSistema(userType);
			registrado = true;
		} catch (InternalServiceException e) {
			sessionUsuario.setError(registrado);
			MotivoEstadoType motivo = manejadorUtil.buscarMotivoPorId(ParametrosErrorConstante.INTERNAL_SERVER_ERROR_COD);
			sessionUsuario.setMensajeError(motivo.getDescripcion());
		}
		if (registrado) {
			return "redirect:/views/portal/pagina/Home";
		}
		return "redirect:/views/portal/pagina/RegistrarUsuario";
	}
	
	/**
	 * Descripcion: metodo para validar los datos requeridos del Formulario.
	 * 
	 * @param nuevoUsuario
	 * @throws DatoRequeridoNoProporcionadoException
	 */
	private void validarDatosRequeridos(RegistrarUsuarioBean nuevoUsuario) throws DatoRequeridoNoProporcionadoException{
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
	private void validarIncidenciaPassword(String password1, String password2) throws InvalidDataException{
		logger.info("entrando en el metodo validarIncidenciaPassword");
		logger.info("iniciando validaciones password proporcionadas");
		if (!password1.equals(password2)) {
			throw new InvalidDataException();
		}
		logger.info("Saliendo del metodo validarIncidenciaPassword");
		logger.info("Finalizando validaciones password");
	}
	
	private void validarUsernameDuplicado(String nombreUsuario) throws DuplicateObjectException{
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
