package com.devs4j.di.Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("QaA")
public class QaEnvironmentServicesImpl implements IEvironmentServices{

	@Override
	public String getEnvironment() {
		return "Configuración del entorno de  Qa del ejecicio A)";
	}

}
