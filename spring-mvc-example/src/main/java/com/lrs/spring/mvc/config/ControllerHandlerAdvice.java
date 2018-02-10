package com.lrs.spring.mvc.config;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

// 控制器全局处理
@ControllerAdvice
public class ControllerHandlerAdvice {

    private final static Logger log = LoggerFactory.getLogger(ControllerHandlerAdvice.class);

    // 全局异常处理
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Throwable throwableHandler(Throwable t){
        log.error("控制器出现异常！",t);
        return t;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","msg"+ Math.random());
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        // 时间格式化
        binder.addCustomFormatter(new Formatter<Date>() {
            @Override
            public Date parse(String text, Locale locale) throws ParseException {
                return DateUtils.parseDate(text,new String[]{"yyyy-MM-dd"});
            }

            @Override
            public String print(Date date, Locale locale) {
                return DateFormatUtils.format((date),"yyyy-MM-dd",locale);
            }
        }, Date.class);
    }
}
