package com.devs4j.di.BeanPostProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;

import com.devs4j.di.beanInicializacion.ClaseB;
import com.devs4j.di.lifeCycle.LifeCycleBean;

@Controller
//La intefaz de la que estamos implemetado, regresa solo un bean
public class VisualizarBeanLevandatodosInicializado implements BeanPostProcessor{

	
	private static final Logger log = LoggerFactory.getLogger(VisualizarBeanLevandatodosInicializado.class);

	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LifeCycleBean) {
			//Imprimir los nombres de los Bean que se van a ejecutar antes de que se inicialice el bean por el contenedor de spring
			log.info("<HF-0.1> antes de inicializar el bean -->Se detectó en la clase VisualizarBeanLevandatodosInicializado, el bean: {}",beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LifeCycleBean) {
			//Imprimir los nombres de los Bean que se ejectan despues  de inicializar el bean por el contenedor de spring
			log.info("<HF-2.1> despues de que se creo el bean -->Se detectó en la clase VisualizarBeanLevandatodosInicializado, el bean: {}",beanName);
		}
		return bean;
	}

}
