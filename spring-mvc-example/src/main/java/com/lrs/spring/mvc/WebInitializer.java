package com.lrs.spring.mvc;

import com.lrs.spring.mvc.config.MvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class WebInitializer implements WebApplicationInitializer {

    private final static String SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 注册配置类
        context.register(MvcConfig.class);

        // 设置servlet上下文
        context.setServletContext(servletContext);
        // 添加核心servlet

        Dynamic servlet = servletContext.addServlet(SERVLET_NAME,new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


    }
}
