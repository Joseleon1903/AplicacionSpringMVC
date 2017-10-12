package com.aplicacion.spring.mvc.vista.beans;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstantes;
import com.aplicacion.spring.mvc.repository.dao.UsuarioRepositoryDao;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Service
public class ManejadorUsuarioBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorUsuarioBean.class);

	@Autowired
	@Qualifier("UsuarioDao")
	private UsuarioRepositoryDao usuarioES;
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
	
	public ManejadorUsuarioBean() {
	}
	
	public String loginUsuario(LoginBean loginBean, UsuarioSession sessionUsuario){
		UsuarioType user = null;
		//validadno si exixte el nombre de ususario proporcionado.
		if (!ValidationUtil.isStringNotNullOrEmpty(loginBean.getCodigoUsuario())) {
			try{
			user = usuarioES.buscarUsuarioPorCodigo(loginBean.getCodigoUsuario());
			}catch (InternalServiceException e) {
				logger.info("Error buscando el codigo Usuario");
				logger.debug("ERROR: "+e.getMessage());
			}
		}
		//validadno si la password proporciondao corresponde con la del usuario.
		logger.info("Iniciando a validar la Password..");
		if (!ValidationUtil.isStringNotNullOrEmpty(loginBean.getPassword()) && user.getPassword().equals(loginBean.getPassword())) {
			logger.info("Password validada con exito..");
			sessionUsuario.setNombre(loginBean.getCodigoUsuario());
			sessionUsuario.setAutenticado(true);
			sessionUsuario.setUsuarioId(user.getUsuarioId());
			return "redirect:/views/portal/pagina/Home";
		}
		//buscando mensaje error usuario invalido
		MotivoEstadoType motivo =manejadorSistemaUtil.buscarMotivoPorId(ParametrosErrorConstantes.USUARIO_INVALIDO_COD);
		loginBean.setCodigoError(motivo.getMotivoId());
		loginBean.setMensajeError(motivo.getDescripcion());
		return "index";
	}
	
	public String validandoSession(UsuarioSession session){
		if (session.isAutenticado()) {
			return "redirect:/views/portal/pagina/Home";
		}
		return "index";		
	}

}
