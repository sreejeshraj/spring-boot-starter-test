package starter.file_to_seda.config.pkg_initializer;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
@Data
public class MyTimerRoute extends RouteBuilder {

    private String timerName;
//    private String logMessage = "myLogMessage";
    private String logMessage;



    @Override
    public void configure() throws Exception {
        from("timer://" + timerName +"?period=3s")
        .log("*** HELLO! I am from dynamically injected timer route!!! - " + logMessage + " ***")
        ;
    }
}
