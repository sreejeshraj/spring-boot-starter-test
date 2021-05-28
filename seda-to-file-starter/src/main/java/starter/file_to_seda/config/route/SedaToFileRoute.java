package starter.file_to_seda.config.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@Data
@EqualsAndHashCode(callSuper=true)
@ConditionalOnProperty(name = "outputFolder")
public class SedaToFileRoute extends RouteBuilder {

	// The value of this property is injected from application.properties based on the profile chosen.

	
	@Override
	public void configure() throws Exception {

		// @formatter:off
		
//		errorHandler(deadLetterChannel("seda:errorQueue").maximumRedeliveries(5).redeliveryDelay(1000));

		from("seda://outputSeda")
		.routeId("OutputSedaToFileRoute")
		.log("***** OutputSedaToFileRoute - exchangeProperty.myProperty:${exchangeProperty.myProperty}")
		.log("***** OutputSedaToFileRoute - exchangeId:${exchangeId}")
		.to("file://{{outputFolder}}")
		.log("\nSTARTER 2 - OutputSedaToFileRoute ***** File written to output folder!!!\n")
		;
//		.log("**** Input File Pushed To Output Folder ***** :"+injectedName);

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
