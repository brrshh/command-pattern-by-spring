package by.bel.main;

import by.bel.main.command.CommandResolver;
import by.bel.main.command.MyCommands;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Barys_Shliaha on 12-Oct-16.
 */
@Configuration
@ComponentScan("by.bel.command.impl")
public class CommandConfiguration {

    @Bean
    public ServiceLocatorFactoryBean getServiceLocatorFactoryBeanMyCommand(){
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(CommandResolver.class);
        return serviceLocatorFactoryBean;
    }

}
