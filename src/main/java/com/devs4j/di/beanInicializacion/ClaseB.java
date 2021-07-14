package com.devs4j.di.beanInicializacion;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy(false)
public class ClaseB {
	
	
	private static final Logger log = LoggerFactory.getLogger(ClaseB.class);

	@PostConstruct
	public void init() {
		log.info("G) Esta es la clase B");
	}

}
