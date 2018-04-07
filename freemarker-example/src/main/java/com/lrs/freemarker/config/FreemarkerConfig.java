package com.lrs.freemarker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Configuration
public class FreemarkerConfig {

    @Value("classpath:freemarker.properties")
    private Resource freemarkerConfig;

    @Bean
    public FreeMarkerConfig freeMarkerConfig() {
        FreeMarkerConfigurer config = new FreeMarkerConfigurer();
        config.setConfigLocation(freemarkerConfig);
        config.setTemplateLoaderPath("WEB-INF/ftl/");
        config.setDefaultEncoding("UTF-8");
        return config;
    }
}
