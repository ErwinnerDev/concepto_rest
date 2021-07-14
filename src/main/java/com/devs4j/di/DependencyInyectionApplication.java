package com.devs4j.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.devs4j.di.Atributos.Coche;
import com.devs4j.di.Atributos.Motor;
import com.devs4j.di.Atributos.model.Ivolar;
import com.devs4j.di.Perfiles.IEvironmentServices;
import com.devs4j.di.asp.TargerObject;
import com.devs4j.di.autowired.AreaCalcularServices;
import com.devs4j.di.autowired.IFigure;
import com.devs4j.di.beanInicializacion.ClaseA;
import com.devs4j.di.beanInicializacion.ClaseB;
import com.devs4j.di.scope.EjemploScopePrototype;
import com.devs4j.di.scope.EjemploScopeSingleton;


@SpringBootApplication
public class DependencyInyectionApplication {

	
	private static final Logger log = LoggerFactory.getLogger(DependencyInyectionApplication.class);

	
	public static void main(String[] args) {
		//Esta sería la forma tradicional
		/*
		 * Motor motor = new Motor("K-124",198); Coche coche = new Coche();
		 * coche.setMarca("MV"); 
		 * coche.setModelo(198); 
		 * coche.setMotor(motor);
		 * System.out.println(coche);
		 */
		
		//Ahora con La inyección de dependecnia y con spring se hace la siguiente manera
		 ConfigurableApplicationContext contex = SpringApplication.run(DependencyInyectionApplication.class, args);
		 Coche coche =contex.getBean(Coche.class);
		 System.out.println(coche);
		 
		 //A)===============================================================
		 //Para utilizar los Environmnet
		 
		IEvironmentServices bean = contex.getBean(IEvironmentServices.class);
		log.info("A) Active Environment: {}",bean.getEnvironment());
		// Para saber que enviromnet se tiene que ejecura se puede configurar de las isguientes maneras
		//1.- se puede hacer desde la configuración del eclise de la sigueinete forma:
					// Run As > run configurations > arguments >(sección) VM argyuments: (y colocar) -Dspring.profiles.active=(Entono a ejecutar)
		//2.- la configuración se está leyendo desde el properties, con la siguente linea: spring.profiles.actives=(Entonro a ejecutar)
		//3.- especificando en la anotación que es el de por defaul, ejemplo: @Profile({"Dev","default"})
		
		

		 //B)===============================================================Scope
		EjemploScopeSingleton objSingleton1 = contex.getBean(EjemploScopeSingleton.class);
		EjemploScopeSingleton objSingleton2 = contex.getBean(EjemploScopeSingleton.class);
		log.info("B) Singleton:"+(objSingleton1==objSingleton2));
		
		EjemploScopePrototype prototype1 = contex.getBean(EjemploScopePrototype.class);
		EjemploScopePrototype prototype2 = contex.getBean(EjemploScopePrototype.class);
		log.info("B) prototype: "+(prototype1==prototype2));
		 
		//C)==============================================================crear un Bean explicito
		//se creao un metodo fuer de este Main para crae el Bean explicito de la Clase String
		 String cadean = contex.getBean(String.class);
		 log.info("C) Bean de tipo: {}",cadean);

		 
		 
		//D)==============================================================inyeccción Autowired multiple
		 AreaCalcularServices calcular = contex.getBean(AreaCalcularServices.class);
		 log.info("D) La suma de todas la areas es: {}",calcular.SumaAreas());
		 
		//E)==============================================================Para ver las diferentes SpEL
		 ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression =  expressionParser.parseExpression("10 le 20");
		log.info("E) String expression {}", expression.getValue());

		//F)==============================================================Ciclos de vida
		Lifecycle lifeCycle = contex.getBean(Lifecycle.class);
		
		//G)========================================================Para ver el comportamiento de los Beaan Lazy y eager
		//contex.getBean(ClaseA.class);		// Como está comentado no se ejecuta el posconstructor, hasta que se descomente (invoque se ejecutarar ) por que es Lazy
		//contex.getBean(ClaseB.class);  //Aún estando comentado SI se va a ejecutar el Poscontructor de esta clase por que es de tipo eager
		
		//contex.getBean(ClaseC.class); // La clase C es de <<Inicialización bean>> eager, y tiene implamentado la claseD
		//contex.getBean(ClaseD.class); // la ClaseD esde tipo Lazy, pero tambien se ejecuta porque fue llamado por la clase C
		
		//H)==========================================BeanPostProcessor
		//la clase VisualizarBeanLevandatodosInicializado implementa la intefaz BeanPostProcessor
		// La cual es capaz de identificar los bean que se van a construir y que se construyen al ejecutarse un bean
		// No es necesario invocar a la clase VisualizarBeanLevandatodosInicializado debido a que se ejecuta automaucamente por Spring
		
		//I)=============================================AOP
		TargerObject objetoTargert = contex.getBean(TargerObject.class);
		objetoTargert.hello("[I] Hola objetoTarget");

	}
	
	//creado el bean explicito para el ejemplo c)
	@Bean
	public String getContecto() {
		return "Este un bean explicito";
	}
	
	

}
