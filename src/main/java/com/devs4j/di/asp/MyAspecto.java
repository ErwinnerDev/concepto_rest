package com.devs4j.di.asp;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Controller
// para utilizar está anotación se importo en mave: spring-boot-starter-aop
@Aspect
//como hay otra clase que tambien es un Aspecto y punta a l amisma clase para hacer el JoinPoint se tiene que especificar cual se ejecutará primero
@Order(0) 
public class MyAspecto {
	
	
	private static final Logger log = LoggerFactory.getLogger(MyAspecto.class);
	
	//Esta es una anotación de tipo de Advices
	//Esisten 5 diferentes tipos de Advice
	//El <<execution>> es obligatorio, (TIPO DE RETORNO(String, Integer,*) Paquete donde está la clase.NombreClase.NombreMentodo(o * en caso se aplicarse atodos los metodos)(Tipo parametro o ..))
	//Se pued epoene aquí  el <<execution(....)>> o llamarlo atravez el PointCut
	//@Before("execution(* com.devs4j.di.asp.TargerObject.hello(..))") //Aquí se define el quie será el Join point
	@Before("PointCutExample.pointTargetObjet()")
	//@Before se ejecuta antes del Join ponint 
	public void before() {
		log.info("[I.0] ASP(0) Advice:Before ejecutandose..");
	}
	
	

	@AfterReturning("execution(void com.devs4j.di.asp.TargerObject.hello(String))") //Aquí se define el quie será el Join point
	//@AfterReturning se ejecuta despues dle jpin pint siempre y cuando no truene
	public void afterReturning(JoinPoint joinPoint) {// el JoinPoint es para obtener datos del JoinPoint que declaromos
		log.info("[I.1] ASP(0) Advice:AfterReturning ejecutandose..");
		log.info("[I.1.1] ASP(0) joinPoint -> Method name: {}",joinPoint.getSignature().getName());
		log.info("[I.1.1] ASP(0) joinPoint -> Objet type: {}",joinPoint.getSignature().getDeclaringType());
		log.info("[I.1.1] ASP(0) joinPoint -> Argument: {}",joinPoint.getArgs());
	}
	
	
	@AfterThrowing("execution(void com.devs4j.di.asp.TargerObject.hello(String))") //Aquí se define el quie será el Join point
	//@AfterThrowing Se ejecuta si el join point truen
	public void AfterThrowing() {
		log.info("[I.*] Advice:AfterThrowing ejecutandose.. en caso de que truene");
	}
	
	//@AfterFinally //se ejecuta siempre depsues del join pint (No me lo reconose pero se suponeee que existe..)
	/*
	 * public void afterFinally() {
	 * log.info("[A.2] Advice:AfterFinally ejecutandose.."); }
	 */
		
	//@Around Revisar la ficha XD
		
		

}
