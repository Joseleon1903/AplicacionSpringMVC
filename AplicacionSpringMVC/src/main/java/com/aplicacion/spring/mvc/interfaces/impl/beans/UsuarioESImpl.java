package com.aplicacion.spring.mvc.interfaces.impl.beans;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.beans.IUsuarioES;
import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Repository
@Transactional
public class UsuarioESImpl implements IUsuarioES{


	@Override
	public UsuarioType buscarUsuarioPorCodigo(String nombre) {
//		ParameterExpression parametros = new ParameterExpression();
//		parametros.addParam("codigoUsuario", nombre);
//		Usuario user = buscarEntityPorNameQueryConRetorno(Usuario.Query.BUSCAR_POR_CODIGO_USUARIO,parametros);
//		return new UsuarioType().toType(user);
		return null;
	}

	@Override
	public boolean ActualizarAccesoUsuario(Usuario usuario) {
//		boolean exitoso = actualizarEntity(usuario);
//		return exitoso;
		return true;
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) {
//		 registrarEntity(usuario);
		return true;
	}

}
