package com.lrs.spring.app;

import com.lrs.spring.app.event.AppEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Swedish-li on 2018/3/28.
 */
@Configuration
public class AppConfig {

    @Bean
    public AppEventListener eventListener(){
        return new AppEventListener();
    }

}
