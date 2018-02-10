package com.lrs.spring.mvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "world")
    public String world(){
        return "Hello World!";
    }

    @RequestMapping("json")
    public Map<String ,Object> jsonResponse(Date time, @ModelAttribute("msg")String msg){

        System.out.println(time);

        Map<String ,Object> map = new HashMap<>();
        map.put("name","Swedish-li");
        map.put("year",2018);
        map.put("msg",msg);

        return map;
    }

}
