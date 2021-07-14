package com.devs4j.di.asp;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExample {
	
	//El <<execution>> es obligatorio, (TIPO DE RETORNO(String, Integer,*) Paquete donde está la clase.NombreClase.NombreMentodo(o * en caso se aplicarse atodos los metodos)(Tipo parametro o ..))
	@Pointcut("execution(* com.devs4j.di.asp.TargerObject.hello(..))")
	public void pointTargetObjet() {
		//Lso metodos con anotación  tiene que ser void y no resive parametros
		//Estos se utiliza para que solo se cambie Aquí y el cambio se vea reflejado en todos los lugares que llaman al PintCut
		
	} 
	
	//El <<execution>> es obligatorio, (TIPO DE RETORNO(String, Integer,*) Paquete donde está la clase.NombreClase.NombreMentodo(o * en caso se aplicarse atodos los metodos)(Tipo parametro o ..))
	@Pointcut("execution(void com.devs4j.di.asp.TargerObject.hello(String))")
	public void pointTargetObjet2() {
		//Este hace extaxtamete lo mismo que el dearriba solo ques es otro ejemplo del execution
	} 
	
	//tambien se puede usar <<within()>> en vez de <<execution()>>
	@Pointcut("within(TargerObject)") // en este caso se puede usar el nombre de la clase porque están en el mismo ppaquete
	//Pero hay má simplementacioones ver las targetas
	public void pointTargetObjet3() {
		//Este hace extaxtamete lo mismo que el dearriba solo ques es otro ejemplo del execution
	} 

}
