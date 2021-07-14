package com.devs4j.di.Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"Dev","default"}) // en caso de que no se configura pro properties o por la cong del VM en run as, sería está el bean por default
public class DevEnvironmentServicesImpl implements IEvironmentServices{

	@Override
	public String getEnvironment() {
		return "Configuración del entorno de Dev";
	}

}
