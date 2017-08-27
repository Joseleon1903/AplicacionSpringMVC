/**
 * 
 */
(function(window , document) {
	// rutas de la pagina web con su contenido
	libreria.getID('prueba').enrutar()
	              .ruta('/', 'portal/contenido/login.html', null, null)
	              .ruta('/registrar-usuario', 'portal/formulario/registrarUsuario.html', null, null)
	              .ruta('/actualizar-usuario', 'portal/contenido/actualizarContacto.html', null, null)
	              .ruta('/lista-email-enviadas', 'portal/contenido/emailEnviadas.html', null, null)
	    	      .ruta('/formulario-envio-email', 'portal/formulario/envioEmail.html', null, null);

})(window , document);