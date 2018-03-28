package com.lrs.spring.mvc.controller;

import com.lrs.spring.app.event.AppEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "world")
    public String world() {
        return "Hello World!";
    }

    @RequestMapping("json")
    public Map<String, Object> jsonResponse(Date time, @ModelAttribute("msg") String msg) throws InterruptedException {

        System.out.println(time);

        AppEvent event = new AppEvent("Hello World!");
        context.publishEvent(event);

        TimeUnit.SECONDS.sleep(3);
        System.out.println("----------------请求休眠结束！-----------------");

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Swedish-li");
        map.put("year", 2018);
        map.put("msg", msg);

        return map;
    }

}
