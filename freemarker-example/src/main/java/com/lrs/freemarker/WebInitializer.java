package com.lrs.freemarker;

import com.lrs.freemarker.config.FreemarkerConfig;
import com.lrs.freemarker.config.MvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{

        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                FreemarkerConfig.class,
                MvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
