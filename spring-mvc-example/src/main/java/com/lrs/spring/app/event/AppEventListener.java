package com.lrs.spring.app.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by Swedish-li on 2018/3/28.
 */
public class AppEventListener implements ApplicationListener<AppEvent> {
    // 异步处理触发的事件
    @Override
    @Async
    public void onApplicationEvent(AppEvent event) {
        System.out.println("触发了app event,事件内容为：" + event.getSource());
    }
}
