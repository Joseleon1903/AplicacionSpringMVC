package com.aplicacion.spring.mvc.vista.beans;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstantes;
import com.aplicacion.spring.mvc.constante.ParametrosSistemaConstantes;
import com.aplicacion.spring.mvc.repository.dao.UsuarioRepositoryDao;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.exception.DatoRequeridoNoProporcionadoException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Component
public class ManejadorActualizarUsuarioBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorActualizarUsuarioBean.class);
	
	@Autowired
	@Qualifier("UsuarioDao")
	private UsuarioRepositoryDao usuarioES;
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorUtil;

	public ManejadorActualizarUsuarioBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ActualizarUsuarioBean buscarUsuarioLoginSistema(Integer usuarioId){
		logger.info("Entrando en la capacidad buscarUsuarioLoginSistema");
		logger.info("UsuarioId : "+ usuarioId);
		logger.info("iniciando busqueda usuario..");
		UsuarioType usuarioSistema=  null;
		try {
			usuarioSistema = usuarioES.buscarUsuarioPorUsuarioId(usuarioId);
		} catch (InternalServiceException e) {
			logger.info("Ocurrio un error buscando el usuario..");
			logger.info("ERROR: "+ e.getMessage());
		}
		ActualizarUsuarioBean actualizarBean = new ActualizarUsuarioBean();
		actualizarBean.setNombre(usuarioSistema.getContacto().getNombre());
		actualizarBean.setApellido(usuarioSistema.getContacto().getApellido());
		actualizarBean.setEmail(usuarioSistema.getContacto().getEmail());
		actualizarBean.setSexo(usuarioSistema.getContacto().getSexo());
		actualizarBean.setFechaNacimiento(usuarioSistema.getContacto().getFechaNacimiento());
		actualizarBean.setUsername(usuarioSistema.getCodigoUsuario());
		if (!ValidationUtil.isObjectNotNull(usuarioSistema.getContacto().getDetalleContactoId())) {
			actualizarBean.setEmailAlternativa(usuarioSistema.getContacto().getDetalleContactoId().getCorreoAlterno());
			actualizarBean.setCelular(usuarioSistema.getContacto().getDetalleContactoId().getCelular());
			actualizarBean.setTelefono(usuarioSistema.getContacto().getDetalleContactoId().getTelefono());
			actualizarBean.setDireccion(usuarioSistema.getContacto().getDetalleContactoId().getDireccion());
		}
		logger.info("Retornando : "+ actualizarBean);
		logger.info("Saliendo de la capacidad buscarUsuarioLoginSistema");
		return actualizarBean;	
	}
	
	public boolean validarDatosActualizarUsuarioBean(ActualizarUsuarioBean input) throws DatoRequeridoNoProporcionadoException{
		logger.info("Entrando en el metodo: validarDatosActualizarUsuarioBean");
		logger.info("ActualizarUsuarioBean: "+input);
		//iniciando validacion de los datos requeridos del dormulario.
		if (ValidationUtil.isStringNotNullOrEmpty(input.getNombre()) ||
				ValidationUtil.isStringNotNullOrEmpty(input.getApellido()) ||
				ValidationUtil.isStringNotNullOrEmpty(input.getEmail()) ||
				ValidationUtil.isStringNotNullOrEmpty(input.getSexo()) ||
				ValidationUtil.isStringNotNullOrEmpty(input.getUsername()) ||
				ValidationUtil.isObjectNotNull(input.getFechaNacimiento())) {
			logger.info("Atencion error validando datos requeridos..");
			throw new DatoRequeridoNoProporcionadoException();
		}
		logger.info("datos requerido para actualizar usuario validados con exito.");
		return true;
	}

	public String actualizandoUsuarioSistema(ActualizarUsuarioBean input, UsuarioSession session) {
		logger.info("iniciando busqueda usuario..");
		String pagina = "portal/pagina/jsp/actualizarContacto";
		UsuarioType usuarioSistema=  null;
		try {
			usuarioSistema = usuarioES.buscarUsuarioPorUsuarioId(session.getUsuarioId());
		} catch (InternalServiceException e) {
			logger.info("Ocurrio un error buscando el usuario..");
			logger.info("ERROR: "+ e.getMessage());
		}
		logger.info("Usuario encontrado "+ usuarioSistema);
		logger.info("incicnado a setear datos a actualizar..");
		usuarioSistema.setCodigoUsuario(input.getUsername());
		usuarioSistema.getContacto().setNombre(input.getNombre());
		usuarioSistema.getContacto().setApellido(input.getApellido());
		usuarioSistema.getContacto().setEmail(input.getEmail());
		usuarioSistema.getContacto().setSexo(input.getSexo());
		usuarioSistema.getContacto().setFechaNacimiento(input.getFechaNacimiento());
		if (ValidationUtil.isObjectNotNull(input.getDireccion()) ||  
			ValidationUtil.isObjectNotNull(input.getEmailAlternativa()) ||
			ValidationUtil.isObjectNotNull(input.getCelular()) ||
			ValidationUtil.isObjectNotNull(input.getTelefono())){
			logger.info("inicializando detalle contacto..");
			DetalleContactoType detalle = new DetalleContactoType();
			if (!ValidationUtil.isObjectNotNull(usuarioSistema.getContacto().getDetalleContactoId())) {
				detalle = usuarioSistema.getContacto().getDetalleContactoId();
			}
			detalle.setCelular(input.getCelular());
			detalle.setTelefono(input.getTelefono());
			detalle.setDireccion(input.getDireccion());
			detalle.setCorreoAlterno(input.getEmailAlternativa());			
		}
		logger.info("Terminando setear datos actualizar contacto..");
		boolean actualizado = false;
		try {
			logger.info("Iniciando a actualizar datos contacto..");
			actualizado = usuarioES.actualizarUsuarioSistema(usuarioSistema);
		} catch (InternalServiceException e) {
			MotivoEstadoType motivo = new MotivoEstadoType();
			motivo =manejadorUtil.buscarMotivoPorId(ParametrosErrorConstantes.INTERNAL_SERVER_ERROR_COD);
			session.setError(true);
			session.setMensajeError(motivo.getDescripcion());
		}
		logger.info("Actualizado: "+actualizado);
		if (actualizado) {
			pagina = ParametrosSistemaConstantes.REDIRECT_STR+ "/views/portal/pagina/Home";
		}
		logger.info("Pagina redireccionar: "+ pagina);
		return pagina;
	}

}
