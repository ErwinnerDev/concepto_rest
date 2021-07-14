package com.devs4j.di.Atributos.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // como hay otra calse que tambien implementa IVolar, esta sera la clase por defecto en caso de que no se utilice el @Qualifiers
public class Pajaro implements Ivolar{

	@Override
	public String volando() {
		return "Soy un pajaro y estoy volando";
	}

}
