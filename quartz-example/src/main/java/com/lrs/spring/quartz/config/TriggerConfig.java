package com.lrs.spring.quartz.config;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

@Configuration
public class TriggerConfig {

    @Autowired
    private JobDetail jobDetail;

    @Bean
    public CronTriggerFactoryBean jobCronTrigger() {

        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

        trigger.setJobDetail(jobDetail);
        trigger.setCronExpression("0/5 * * ? * *");

        return trigger;
    }

}
