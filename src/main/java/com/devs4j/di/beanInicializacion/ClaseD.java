package com.devs4j.di.beanInicializacion;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class ClaseD {
private static final Logger log = LoggerFactory.getLogger(ClaseC.class);
	
	@PostConstruct
	public void init() {
		log.info("G) Esta es la clase D 'Lazy' que se llama en C");
	}
}
