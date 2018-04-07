package com.lrs.freemarker.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

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
                .cache(false)
                .attributes(freemarkerAttr());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    private LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultTimeZone(TimeZone.getDefault());
        resolver.setDefaultLocale(Locale.CHINA);

        return resolver;
    }
}
