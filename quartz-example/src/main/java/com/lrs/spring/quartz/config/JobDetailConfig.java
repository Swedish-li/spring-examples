package com.lrs.spring.quartz.config;

import com.lrs.spring.quartz.task.SimpleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import java.util.HashMap;

@Configuration
@ComponentScan("com.lrs.spring.quartz.task")
public class JobDetailConfig {

    @Autowired
    private SimpleTask task;

    @Bean
    public JobDetailFactoryBean methodJob() {
        JobDetailFactoryBean jobFactory = new JobDetailFactoryBean();
        jobFactory.setJobClass(SimpleTask.class);

        jobFactory.setDurability(true);
        jobFactory.setBeanName("simpleTask");

        return jobFactory;

    }


}
