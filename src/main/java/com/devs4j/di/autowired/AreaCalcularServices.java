package com.devs4j.di.autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaCalcularServices {
	
	@Autowired
	private List<IFigure> figura;
	
	public double SumaAreas() {
		return figura.stream().mapToDouble(x -> x.calculararea()).sum();
	}

}
