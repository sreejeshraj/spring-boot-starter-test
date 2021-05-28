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
		.routeId("TestSedaToOutputFolderRoute")
		.log("***** TestSedaToOutputFolderRoute - exchangeProperty.myProperty:${exchangeProperty.myProperty}")
		.log("***** TestSedaToOutputFolderRoute - exchangeId:${exchangeId}")
		.to("file://{{outputFolder}}")
//		.log("***** myHeader: ${header.myHeader} ***** :"+injectedName)
		;
		

		
		// @formatter:on

	}

}
