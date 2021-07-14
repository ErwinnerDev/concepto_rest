package com.devs4j.di.beanInicializacion;


import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy(false)
public class ClaseC {

	
	private static final Logger log = LoggerFactory.getLogger(ClaseC.class);
	
	@Autowired
	ClaseD d;
	//La claseC es de <<Inicialización bean>> de tipo eager
	//y está llamado a una CLaseD que es de tipo Lazy
	//La claseD se comportará como eagre, debido a que la ClaseC se tiene que construir (incluyendo a la clase que manda a invocar)
	
	@PostConstruct
	public void init() {
		log.info("G) Esta es la clase C 'eager' que invaca a D");
	}

}
