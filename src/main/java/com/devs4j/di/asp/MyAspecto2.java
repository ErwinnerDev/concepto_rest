package com.devs4j.di.asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
//como hay otra clase que tambien es un Aspecto y punta a l amisma clase para hacer el JoinPoint se tiene que especificar cual se ejecutará primero
@Order(1)
public class MyAspecto2 {
	
	
	private static final Logger log = LoggerFactory.getLogger(MyAspecto2.class);


	@Before("PointCutExample.pointTargetObjet()")//Aquí se define el quie será el Join point  
	public void before() {
		log.info("[I.0] ASP(1) Advice:Before ejecutandose..");
	}
	
	
	@Before("PointCutExample.pointTargetObjet3()")
	public void afterReturning(JoinPoint joinPoint) {
		log.info("[I.1] ASP(1) Advice:AfterReturning ejecutandose..");
		log.info("[I.1.1] ASP(1) joinPoint -> Method name: {}",joinPoint.getSignature().getName());
		log.info("[I.1.1] ASP(1) joinPoint -> Objet type: {}",joinPoint.getSignature().getDeclaringType());
		log.info("[I.1.1] ASP(1) joinPoint -> Argument: {}",joinPoint.getArgs());
	}
	

}
