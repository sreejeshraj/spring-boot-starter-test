package starter.file_to_seda.config.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@ConfigurationProperties(prefix="camel-demo-route")
@Data
@EqualsAndHashCode(callSuper=true)
@ConditionalOnProperty(name = "inputFolder")
public class FileToSedaRoute extends RouteBuilder {

	// The value of this property is injected from application.properties based on the profile chosen.
	private String injectedName;
	
	@Override
	public void configure() throws Exception {

		// @formatter:off
		
//		errorHandler(deadLetterChannel("seda:errorQueue").maximumRedeliveries(5).redeliveryDelay(1000));

		from("file://{{inputFolder}}?delay=10s&noop=true")
		.routeId("InputFolderToTestSedaRoute")
		.setProperty("myProperty", constant("myPropertyValue"))
		.setHeader("myHeader", constant("MY_HEADER_CONSTANT_VALUE"))
		.to("seda://testSeda")
		.log("***** InputFolderToTestSedaRoute - exchangeProperty.myProperty:${exchangeProperty.myProperty}")
		.log("***** InputFolderToTestSedaRoute - exchangeId:${exchangeId}")
		.log("**** Input File Pushed To Output Folder ***** :"+injectedName);

		/*from("seda://testSeda")
		.routeId("TestSedaToOutputFolderRoute")
		.log("***** TestSedaToOutputFolderRoute - exchangeProperty.myProperty:${exchangeProperty.myProperty}")
		.log("***** TestSedaToOutputFolderRoute - exchangeId:${exchangeId}")
		.to("seda://outputFileSeda");

		from("seda://outputFileSeda")
		.to("file://{{outputFolder}}")
		.log("***** myHeader: ${header.myHeader} ***** :"+injectedName);*/
		
		//Error Handling route!
		

		
		
		// @formatter:on

	}

}
