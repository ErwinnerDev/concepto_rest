package com.devs4j.di.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean implements BeanNameAware,InitializingBean,DisposableBean{
	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	/*Se ejecuta durante la creación del Bean
	 * De la intefaz: BeanNameAware
	 * */
	@Override
	public void setBeanName(String name) {
		log.info("<F-0> El nombre del BeanAware es: {}",name);
	}
	
	/*
	 * Se ejecuta despues de la inyección de la dependencia*/
	@PostConstruct
	public void init() {
		log.info("<F-1> post constructor");
	}
	
	/*
	 * Se ejecutara justo antes de que el bean sea destruido
	 * No se ejjecutan para bean con scope prototype
	 * Solo se ejcuta dutante una teminación normal  de la VM  de forma natural
	 * */
	 @PreDestroy
	public void destroyBean() {
		log.info("<F-3> Pre destroy");
	}
	 
	 
	 /*
	  * De la intefaz: InitializingBean
	  * */
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("<F-2> Ejecutando un afterPropertiesSet de la clase:LifeCycleBean");
		
	}

	/*
	 * De la Intefaz:DisposableBean
	 * */
	@Override
	public void destroy() throws Exception {
		log.info("<F-4> Ejecutando un destroy de la clase:LifeCycleBean");
		
	}

}
