package com.devs4j.di.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements IFigure {

	@Value("${circul.radio:1}")
	private double radio;
	
	@Override
	public double calculararea() {
		
		return Math.PI * Math.pow(radio, 2);
	}

}
