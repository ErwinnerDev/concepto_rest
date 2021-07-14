package com.devs4j.di.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:area.properties")
public class FigurePropertiesConfiguration {
	
		public PropertySourcesPlaceholderConfigurer getPropiertesConfig() {
			return new PropertySourcesPlaceholderConfigurer();
		}

}
