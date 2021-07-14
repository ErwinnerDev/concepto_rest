/**
 * 
 */
package com.devs4j.di.Atributos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author dimen
 *
 */
@Component
public class Coche {
	
	//@Value("MV")
	private String marca;
	//@Value("198") // se le pasa un valor al atributo, Inyeccción por atributo
	private Integer modelo;
	//@Autowired // inyección de atributo/objeto
	private Motor motor;
	

	public Coche() {
	}
	
	//Esta es una inyección por constructor
	/*
	 * @Autowired public Coche(@Value("MV") String marca,@Value("198") Integer modelo,Motor motor) 
	 * { 
	 * this.marca = marca; 
	 * this.modelo = modelo; 
	 * this.motor = motor; 
	 * }
	 */
	public String getMarca() {
		return marca;
	}
	
	@Value("MV") 
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getModelo() {
		return modelo;
	}
	
	@Value("198")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public Motor getMotor() {
		return motor;
	}
	
	@Autowired
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}

}
