package com.sreejesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import starter.file_to_seda.config.comp.DynamicBeanDefinitionSupplier;
import starter.file_to_seda.config.comp.MyNormalClass;
import starter.file_to_seda.config.comp.NormalComponent;
import starter.file_to_seda.config.greeting.Hello;

//import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:META-INF/spring/applicationContext.xml") 
public class SBMainClass implements ApplicationRunner {

	@Autowired
	Hello hello;

	@Autowired
	DynamicBeanDefinitionSupplier dynamicBeanDefinitionSupplier;

	@Autowired
	@Qualifier("myNormalClass1")
	MyNormalClass myNormalClassDynamicallyCreated;

	@Autowired
	NormalComponent nc;

	@Autowired
	SampleComponent sc;

	public static void main(String[] args) {
		SpringApplication.run(SBMainClass.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("\n\n****** ApplicationRunner has executed!!! *****\n\n");
		System.out.println(hello.sayHello());
		System.out.println(myNormalClassDynamicallyCreated.sayHelloFromMyNormalClass());
		System.out.println("dynamicBeanDefinitionSupplier.getTestInjectedValue():"+dynamicBeanDefinitionSupplier.getTestInjectedValue());
		System.out.println("nc.getNcString():"+nc.getNcString());
		System.out.println("sc.getScString():"+sc.getScString());
		System.out.println("sc.getEndpointMapList():"+sc.getEndpointMapList());
		System.out.println("\n\n****** ApplicationRunner has exited!!! *****\n\n");
	}
}
