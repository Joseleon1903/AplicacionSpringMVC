package com.aplicacion.spring.mvc.vista.beans;

import javax.ejb.EJB;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Component
public class ManejadorActualizarUsuarioBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorActualizarUsuarioBean.class);
	
	@EJB(mappedName = "java:global/AplicacionSpringMVC/UsuarioEjbImpl!com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl")
	private UsuarioEjbImpl usuarioES;
	
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
		actualizarBean.setFechaNacimiento(usuarioSistema.getContacto().getFechaNacimineto());
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
	
	
	

}
