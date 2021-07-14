package com.devs4j.di.asp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class TargerObject {

	// a esta calse le están invocando una programación orientada a Aspectos (AOP)
	// por la clase MYAspecto
	private static final Logger log = LoggerFactory.getLogger(TargerObject.class);
	
	public void hello(String message) {
		log.info(message);
	}
}
