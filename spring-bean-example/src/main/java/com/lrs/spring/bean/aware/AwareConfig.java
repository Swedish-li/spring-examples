package com.lrs.spring.bean.aware;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan("com.lrs.spring.bean.aware")
public class AwareConfig {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("msg/message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBundleClassLoader(AwareConfig.class.getClassLoader());
        return messageSource;
    }
}
