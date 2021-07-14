package com.devs4j.di.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements IFigure {
	
	@Value("${squaret.lado}")
	private double lado;

	@Override
	public double calculararea() {
		return lado*lado;
	}

}
