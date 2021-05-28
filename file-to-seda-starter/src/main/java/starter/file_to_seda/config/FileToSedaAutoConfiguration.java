package starter.file_to_seda.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import starter.file_to_seda.config.greeting.Hello;
import starter.file_to_seda.config.greeting.HelloImpl;

@Configuration
@ComponentScan
public class FileToSedaAutoConfiguration {

    /*public FileToSedaAutoConfiguration()
    {
        System.out.println("***** FileToSedaAutoConfiguration Constructor called!!! *****");
    }*/

    @Bean
    public Hello hello()
    {
        return new HelloImpl();
    }

}
