package com.lrs.freemarker;

import com.lrs.freemarker.config.FreemarkerConfig;
import com.lrs.freemarker.config.MvcConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

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

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                encodingFilter()
        };
    }

    private Filter encodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
