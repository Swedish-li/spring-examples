package com.lrs.spring.property;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PropertyConfigTest {

    private ConfigurableApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(PropertyConfig.class);
    }

    @Test
    public void testConfig() throws Exception {
        PropertyConfig propertyConfig = context.getBean(PropertyConfig.class);

        assertThat(propertyConfig.str, equalTo("spring.property"));

        assertThat(propertyConfig.classProperty, equalTo("その言葉の意味を探し始める"));

        assertThat(IOUtils.toString(propertyConfig.file.getURL(), "UTF-8"), equalTo("ヴァイオレット・エヴァーガーデン"));

        assertThat(propertyConfig.serverName, equalTo("Swedish-li"));

        assertThat(propertyConfig.env.getProperty("server.name"), equalTo("Swedish-li"));

        System.out.println(propertyConfig.osName);
        System.out.println(propertyConfig.randomNumber);
        System.out.println(IOUtils.toString(propertyConfig.url.getURL(), "UTF-8"));
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }
}