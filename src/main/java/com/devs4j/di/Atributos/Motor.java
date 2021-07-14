/**
 * 
 */
package com.devs4j.di.Atributos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author dimen
 *
 */
@Component
public class Motor {
	
	//El value es un valor por defecto, es una inyeccción de dependencia por atributos
	//@Value("K-124")
	private String	marca;
	//@Value("198")
	private Integer modelo;
	
	
	//Inyección de dependencia por contructor
	public Motor(@Value("K-124") String marca,@Value("198") Integer modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
	}

}
