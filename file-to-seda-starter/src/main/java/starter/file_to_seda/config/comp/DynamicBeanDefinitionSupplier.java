package starter.file_to_seda.config.comp;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "dbds")
public class DynamicBeanDefinitionSupplier implements BeanDefinitionRegistryPostProcessor {

    private List<Map<String, String>> endpointMapList;
    private String testInjectedValue;



    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("\n\n***** endpointMapList:"+endpointMapList+"\n\n");
        System.out.println("\n\n***** testInjectedValue:"+testInjectedValue+"\n\n");

        registry.registerBeanDefinition("myNormalClass1",
                BeanDefinitionBuilder.genericBeanDefinition(MyNormalClass.class).getBeanDefinition());

        registry.registerBeanDefinition("myNormalClass2",
                BeanDefinitionBuilder.genericBeanDefinition(MyNormalClass.class).getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
