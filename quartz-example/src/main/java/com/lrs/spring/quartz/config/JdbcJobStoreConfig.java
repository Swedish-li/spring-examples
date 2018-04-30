package com.lrs.spring.quartz.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class JdbcJobStoreConfig {
    @Value("classpath:quartz.properties")
    private Resource quartz;

    @Autowired
    private CronTrigger trigger;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean
    public SchedulerFactoryBean schedulerFactory() throws PropertyVetoException {

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setConfigLocation(quartz);
        factory.setTriggers(trigger);
        return factory;
    }

}
