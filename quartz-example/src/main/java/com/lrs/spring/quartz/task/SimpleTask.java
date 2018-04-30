package com.lrs.spring.quartz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleTask implements Job {

    private static final Logger log = LoggerFactory.getLogger(SimpleTask.class);

    public void doTask() {

        System.out.println("---------com.lrs.spring.quartz.doTask------------------");
        System.out.println("SimpleTask");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        doTask();
    }
}
