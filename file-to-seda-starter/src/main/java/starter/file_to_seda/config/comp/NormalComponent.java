package starter.file_to_seda.config.comp;


import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "nc")
public class NormalComponent {
//public class NormalComponent implements BeanDefinitionRegistryPostProcessor {
//    If we enable the above line, injected value from properties won't be available (ncString)
//    This happens as soon as we implement BeanDefinitionRegistryPostProcessor.
//    Else it will work as a normal Spring Bean with all injected values available
    private String ncString;

    /*@Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }*/
}
