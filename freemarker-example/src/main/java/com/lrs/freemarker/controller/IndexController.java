package com.lrs.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("val", "FreeMarker");
        model.addAttribute("nowDate", new Date());
        response.setContentType("text/html; charset=utf-8");
        return "index";
    }
}
