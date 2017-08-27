package com.aplicacion.rest.html.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *  Descripcion: el uso de una clase beanPostProcessor para manejar los eventos antes
 *  y después de la inicialización de un bean por medio del core container.
 *  
 *  Para utilizar esta clase es suficiente hacer referencia a ella en el beans.xml 
 *  ejemplo: 
 *  
 *  <bean class="com.aplicacion.ejemplo.beans.EjemploBeanPosProcessor"> </bean>
 *  
 * @author Jose Eduardo
 *
 */
public class EjemploBeanPostProcessor implements BeanPostProcessor{

	public EjemploBeanPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

}
