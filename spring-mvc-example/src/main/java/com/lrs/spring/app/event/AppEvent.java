package com.lrs.spring.app.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * <p>
 * Created by Swedish-li on 2018/3/28.
 */
public class AppEvent extends ApplicationEvent {

    public AppEvent(String source) {
        super(source);
    }
}
