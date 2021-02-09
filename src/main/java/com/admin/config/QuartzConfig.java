package com.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


@Configuration
public class QuartzConfig{

    @Bean
    public SchedulerFactoryBean schedulerFactory(){
        return new SchedulerFactoryBean();
    }

}
