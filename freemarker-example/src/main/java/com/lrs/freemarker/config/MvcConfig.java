package com.lrs.freemarker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@EnableWebMvc
@Configuration
@ComponentScan("com.lrs.freemarker.controller")
public class MvcConfig implements WebMvcConfigurer {

    private Map<String, Object> freemarkerAttr() {
        Map<String, Object> attr = new HashMap<>();
        attr.put("contentType", "text/html;charset=UTF-8");
        attr.put("requestContextAttribute", "ctx");
        attr.put("exposeSpringMacroHelpers", true);
        return attr;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker()
                .suffix(".ftl")
                .attributes(freemarkerAttr());
    }
}
