package com.lrs.spring.quartz;

import com.lrs.spring.quartz.config.JdbcJobStoreConfig;
import com.lrs.spring.quartz.config.JobDetailConfig;
import com.lrs.spring.quartz.config.TriggerConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    private final static String SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 注册配置类
        context.register(
                JobDetailConfig.class,
                TriggerConfig.class,
                JdbcJobStoreConfig.class
        );


        // 设置servlet上下文
        context.setServletContext(servletContext);
        // 添加核心servlet

        ServletRegistration.Dynamic servlet = servletContext.addServlet(SERVLET_NAME, new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
