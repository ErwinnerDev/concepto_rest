package com.devs4j.di.beanInicializacion;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy // los Lazy se ejecutan hasta que el bean son invocados
//@Lazy(false) los eagre Se ejecutan sin necesisda de que sean invocados/llamdos/declados
//Los bean con Scope singleton son por default de tipo eager
//Los bean con Scope prototype son por default son de tipo Lazy (peresoso)
//Si una clase tiene <<inicializacion bean>> eager llama/invoca a una clase lazy, ambas se compartarán como eagre para que se temine de construir el beab (ejemplo clase C y D)
public class ClaseA {
	
	private static final Logger log = LoggerFactory.getLogger(ClaseA.class);

	@PostConstruct
	public void init() {
		log.info("G) Esta es la clase A");
	}

}
