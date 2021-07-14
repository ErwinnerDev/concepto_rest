/**
 * 
 */
package com.devs4j.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import com.devs4j.di.Atributos.model.Ivolar;

/**
 * @author dimen
 *
 */
@Controller
public class ImplemantacionIyeccion {
	
	@Autowired
	//@Qualifier("Pajaro") // La interfaz tiene dos implementacioones y para saber cual de las 2 es la que se tiene que implimentar
	// ó se puede usar la anotación @Primary en la clase por defauly
	Ivolar volar;
	
	//Aquí va ala anotación @GetMapping peor como este proyecto no tiene las dependencias de 
	//Spring web no de de Sppring boo no deja implemantar la anotación
	public String accion(){
		return volar.volando();
	}

}
