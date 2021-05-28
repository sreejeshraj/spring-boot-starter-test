package com.sreejesh.demo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
//@ConfigurationProperties(prefix="camel-demo-route")
@Data
@EqualsAndHashCode(callSuper=true)

public class CamelDemoRoute extends RouteBuilder {

	// The value of this property is injected from application.properties based on the profile chosen.
//	private String injectedName;
	
	@Override
	public void configure() throws Exception {

		// @formatter:off
		



		from("seda://testSeda")
		.routeId("TestSedaToOutputSedaRoute")
		.log("***** TestSedaToOutputSedaRoute - exchangeProperty.myProperty:${exchangeProperty.myProperty}")
		.to("seda://outputSeda")
		.log("\nCLIENT APP ***** TestSedaToOutputSedaRoute - Pushed message to outputSeda!\n")
//		.to("file://{{outputFolder}}")
//		.log("***** myHeader: ${header.myHeader} ***** :"+injectedName)
		;
		

		
		// @formatter:on

	}

}
