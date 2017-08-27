package com.aplicacion.rest.html.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aplicacion.rest.html.beans.AppConfig;
import com.aplicacion.rest.html.beans.AppConfig2;
import com.aplicacion.rest.html.beans.Celular;
import com.aplicacion.rest.html.beans.Ciudad;
import com.aplicacion.rest.html.beans.Ciudadano;
import com.aplicacion.rest.html.beans.Jugador;
import com.aplicacion.rest.html.beans.Manzana;
import com.aplicacion.rest.html.beans.Movil;
import com.aplicacion.rest.html.beans.Mundo;
import com.aplicacion.rest.html.beans.Pasajero;
import com.aplicacion.rest.html.beans.Persona;
import com.aplicacion.rest.html.beans.Player;
import com.aplicacion.rest.html.beans.Telefono;
import com.aplicacion.rest.html.beans.interfaces.IEquipo;

public class App {


	public static void main(String[] args) {
		//accediendo desde archivo xml al bean 
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);
		//
		Mundo m = (Mundo) appContext.getBean("mundo");
		Mundo m2 = (Mundo) appContext.getBean("mundo2");

		System.out.println("llamando saludar"+ m.getSaludo());
		System.out.println("llamando saludar"+ m2.getSaludo());
		
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("-----------Fin Introduccion Mundo------");
		
		InyeccionConstructorBeans();
		
		InyeccionDeObjeto();
				
		inicializarColeccionListaBeans();
		
		provandoPropriedadAutowire();
		
		provandoPropriedadLazy();
		
		provandoCicloDeVidaBeans();
		
		provandoAnotacionesCicloDeVidaBeans();
		
		provandoAnotacionesCicloDeVidaBeansConInterfaces();
		
		provandoUsoDeInterfaces();
		
		provandoUsoDeTagAutowire();
		
		provandoUsoDeStereotypes();

	}
	
	/**
	 * El uso de la inyección de dependencias que brinda spring por medio de su container, a nivel de constructor
	 */
	public static void InyeccionConstructorBeans(){
		System.out.println("---------- BEGIN InyeccionConstructorBeans--");
		System.out.println("Inyeccion de un constructor utulizando el archivo beans.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Persona m = (Persona) appContext.getBean("persona");
		
		System.out.println("Result: "+ m);
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END InyeccionConstructorBeans------");

	}
	
	/**
	 * Ejemplo de  como inyectar los valores de los objetos contenidos en otros objetos.
	 */
	public static void InyeccionDeObjeto(){
		System.out.println("---------- BEGIN InyeccionDeObjeto--");
		System.out.println("Inyeccion de un constructor utulizando el archivo beans.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Persona m = (Persona) appContext.getBean("persona");
		m.setId(1);
		m.setNombre("Objeto");
		m.setApodo("Mi pais");
		System.out.println("Result: "+ m+ "Pais Persona: "+ m.getPais().getNombre());
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END InyeccionDeObjeto------");
	}
	
	/**
	 * inicializar las colecciones (listas) en spring framework
	 */
	public static void inicializarColeccionListaBeans(){
		System.out.println("---------- BEGIN inicializarColeccionListaBeans--");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Persona m = (Persona) appContext.getBean("persona");
		String nombreCiudades = "";
		for (Ciudad iterable : m.getPais().getCiudades()) {
			nombreCiudades += iterable.getCodigo()+ " - "+ iterable.getNombre()+","; 
		}
		
		System.out.println("Result: "+nombreCiudades);
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END inicializarColeccionListaBeans------");
	}
	
	/**
	 * Por medio de esta propiedad se podrá hacer una relación implicita de las dependencias de los beans.
	 * 
	 */
	public static void provandoPropriedadAutowire(){
		System.out.println("---------- BEGIN provandoPropriedadAutowire--");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Pasajero pasajero = (Pasajero) appContext.getBean("pasajero");
		
		System.out.println("Result: "+ pasajero);
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoPropriedadAutowire------");

	}
	
	/**
	 * Por medio de esta propiedad se manipular la instanciación de los beans.
	 * 
	 */
	public static void provandoPropriedadLazy(){
		System.out.println("---------- BEGIN provandoPropriedadLazy --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Telefono tele = (Telefono) appContext.getBean("telefono");
		
		System.out.println("Result: "+ tele);
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoPropriedadLazy ------");

	}
	
	/**
	 * Por medio de esta propiedad se podrá hacer una relación implicita de las dependencias de los beans.
	 * 
	 */
	public static void provandoCicloDeVidaBeans(){
		System.out.println("---------- BEGIN provandoCicloDeVidaBeans --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Ciudadano ciu = (Ciudadano) appContext.getBean("ciudadano");
		
		System.out.println("Result: "+ ciu.getMatricula());
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoCicloDeVidaBeans ------");

	}
	
	/**
	 * como controlar el ciclo de vida gracias a estas dos anotaciones de la especificación de Java CDI.
	 * 
	 */
	public static void provandoAnotacionesCicloDeVidaBeans(){
		System.out.println("---------- BEGIN provandoAnotacionesCicloDeVidaBeans --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Movil mov = (Movil) appContext.getBean("movil");
		
		System.out.println("Result: "+ mov);
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoAnotacionesCicloDeVidaBeans ------");

	}
	
	/**
	 * Controlar los eventos después de la inicialización de un bean y antes de su destrucción es
	 *  mediante el uso de las interfaces InitializingBean y DisposableBean.
	 * 
	 */
	public static void provandoAnotacionesCicloDeVidaBeansConInterfaces(){
		System.out.println("---------- BEGIN provandoAnotacionesCicloDeVidaBeansConInterfaces --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans.xml");
		Manzana man = (Manzana) appContext.getBean("manzana");
		
		System.out.println("Result: "+ man);
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoAnotacionesCicloDeVidaBeansConInterfaces ------");
	}
	
	/**
	 * Codificar bajo interfaces para obtener mayor flexibilidad en el código
	 *  al momento de instanciar objetos de diferentes clases.
	 * 
	 */
	public static void provandoUsoDeInterfaces(){
		System.out.println("---------- BEGIN provandoUsoDeInterfaces --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans2.xml");
		Jugador gamer = (Jugador) appContext.getBean("messi");
		IEquipo equipo = (IEquipo) appContext.getBean("barcelona");
		IEquipo equipo2 = (IEquipo) appContext.getBean("juventus");
		
		System.out.println("Result: "+ gamer.getNombre() +" - "+ gamer.getEquipo().montrarNombre());
		System.out.println("Result Interface: " + equipo.montrarNombre());
		System.out.println("Result Interface: " + equipo2.montrarNombre());
		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoUsoDeInterfaces ------");
	}
	
	/**
	 * Unas de las más usadas anotaciones es Autowired y Qualifier, las que te permitirán 
	 * realizar un seteo de tus propiedades de manera automática.
	 * 
	 */
	public static void provandoUsoDeTagAutowire(){
		System.out.println("---------- BEGIN provandoUsoDeTagAutowire --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans2.xml");
		Player gamer = (Player) appContext.getBean("player");
	
		
		System.out.println("Result: "+ gamer.getNombre() +" - "+ gamer.getEquipo().montrarNombre());

		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoUsoDeTagAutowire ------");
	}
	
	/**
	 * 
	 * Spring te permite usar anotaciones para simplificar las definiciones
	 *  en el archivo de configuración xml,estas anotaciones son @Component,
	 *   @Service @Controller, @Repository conocido como esteriotipos
	 * 
	 */
	public static void provandoUsoDeStereotypes(){
		System.out.println("---------- BEGIN provandoUsoDeStereotypes --");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("XML/beans2.xml");
		Celular gamer = (Celular) appContext.getBean("componente");
		
		System.out.println("Result: "+ gamer);

		((ConfigurableApplicationContext)appContext).close();
		System.out.println("---------- END provandoUsoDeStereotypes ------");
	}

	

}
