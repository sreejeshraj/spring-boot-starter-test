package starter.file_to_seda.config.pkg_initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;

public class ProgrammaticBeanDefinitionInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        System.out.println("\n\nHELLO ApplicationContextInitializer!!!\n\n");
        Environment environment = applicationContext.getEnvironment();
        System.out.println("\n\nenvironment.getProperty(\"dbds.testInjectedValue\"):"+environment.getProperty("dbds.testInjectedValue")+"\n\n");

        /*applicationContext.registerBean("myTimerOne",MyTimerRoute.class);
        //the above statement will be overwritten by below one as there is only one default bean name
        applicationContext.registerBean("myTimerTwo",MyTimerRoute.class);*/
        MyTimerRoute myTimerRouteOne = new MyTimerRoute("timerOne", "logMessageOne");
        MyTimerRoute myTimerRouteTwo = new MyTimerRoute("timerTwo", "logMessageTwo");

        applicationContext.registerBean("myTimerOne",MyTimerRoute.class, () -> myTimerRouteOne);
        applicationContext.registerBean("myTimerTwo",MyTimerRoute.class, () -> myTimerRouteTwo);

        System.out.println("\n\nEXITING ApplicationContextInitializer!!!\n\n");
    }
}
