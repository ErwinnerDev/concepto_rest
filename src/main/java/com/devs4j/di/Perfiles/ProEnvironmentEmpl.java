package com.devs4j.di.Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Pro")
public class ProEnvironmentEmpl implements IEvironmentServices{

	@Override
	public String getEnvironment() {
		return "Configuración del entorno de Produccion";
	}

}
