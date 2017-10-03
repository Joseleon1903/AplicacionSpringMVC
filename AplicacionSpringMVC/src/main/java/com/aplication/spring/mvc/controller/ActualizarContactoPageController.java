package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstantes;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplicacion.spring.mvc.vista.beans.ActualizarUsuarioBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorActualizarUsuarioBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;
import com.aplication.spring.mvc.exception.DatoRequeridoNoProporcionadoException;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Controller
@RequestMapping(value = "/views/portal/pagina/ActualizarContacto")
public class ActualizarContactoPageController {
	
	private static final Logger logger = Logger.getLogger(ActualizarContactoPageController.class);

	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@Autowired
	@Qualifier("actualizarUsuarioBean")
	private ActualizarUsuarioBean actualizarUsuarioBean;
	
	@Autowired
	@Qualifier("manejadorActualizarUsuarioBean")
	private ManejadorActualizarUsuarioBean manejadorActualizarUsuario;

	@RequestMapping(method = RequestMethod.GET)
	public String displayActualizarContactoPage(HttpServletRequest request,  Model model) {
		logger.info("UsuarioSession: " + sessionUsuario);
		String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "portal/pagina/jsp/actualizarContacto");
		actualizarUsuarioBean = manejadorActualizarUsuario.buscarUsuarioLoginSistema(sessionUsuario.getUsuarioId());
		model.addAttribute("SessionUsuario", sessionUsuario);
		model.addAttribute("ActualizarUsuarioBean", actualizarUsuarioBean);
		logger.info("cargando pagina: "+ pagina);
		return pagina;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String procesarFormPage(ActualizarUsuarioBean actualizarBean,  Model model) {
		logger.info("entrando en el metodo procesarFormPage");
		logger.info("ActualizarUsuarioBean: "+actualizarBean);
		String pagina = "portal/pagina/jsp/actualizarContacto";
		boolean formularioValido = false;
		try {
			 formularioValido = manejadorActualizarUsuario.validarDatosActualizarUsuarioBean(actualizarBean);
		} catch (DatoRequeridoNoProporcionadoException e) {
			MotivoEstadoType motivo = null;
			motivo = manejadorSistemaUtil.buscarMotivoPorId(ParametrosErrorConstantes.DATOS_REQUERIDO_ERROR_COD);
			sessionUsuario.setError(true);
			sessionUsuario.setMensajeError(motivo.getDescripcion());
		}
		logger.info("terminando validar Formulario");
		if (formularioValido) {
			logger.info("inciando a actualizar usuario..");
			pagina = manejadorActualizarUsuario.actualizandoUsuarioSistema(actualizarBean, sessionUsuario);
		}
		model.addAttribute("SessionUsuario", sessionUsuario);
		model.addAttribute("ActualizarUsuarioBean", actualizarBean);
		return pagina;
	}

}
