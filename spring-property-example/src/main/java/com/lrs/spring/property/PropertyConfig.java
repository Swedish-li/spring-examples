package com.lrs.spring.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;


@Configuration
@PropertySource("classpath:config/app.properties")
@ComponentScan("com.lrs.spring.property")
public class PropertyConfig {
    /**
     * 配置文件读取
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourceConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // 注入字符串
    @Value("spring.property")
    public String str;

    // spring el
    // 系统属性注入
    @Value("#{systemProperties['os.name']}")
    public String osName;

    // 静态方法调用
    @Value("#{T(java.lang.Math).random() * 100.0}")
    public double randomNumber;

    // 类的属性注入
    @Value("#{propertyService.val}")
    public String classProperty;

    // url资源注入
    @Value("http://www.anitama.cn/")
    public Resource url;

    // 文件资源注入
    @Value("classpath:document.txt")
    public Resource file;

    // 文件配置注入
    @Value("${server.name}")
    public String serverName;

    // 从Environment中获取配置
    @Autowired
    public Environment env;
}
