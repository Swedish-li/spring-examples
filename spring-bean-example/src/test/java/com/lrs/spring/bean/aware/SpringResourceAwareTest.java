package com.lrs.spring.bean.aware;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SpringResourceAwareTest {

    private AbstractApplicationContext context;

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(AwareConfig.class);
    }

    private SpringResourceAware getAware() {
        return context.getBean(SpringResourceAware.class);
    }

    @Test
    public void testResource() throws IOException {
        String str = "The Apache Commons CLI library provides an API for parsing command line options passed to programs."
                + System.lineSeparator()
                + "It's also able to print help messages detailing the options available for a command line tool.";
        assertThat(getAware().getResource(), equalTo(str));
    }

    @Test
    public void testBeanName() {
        String name = getAware().getBeanName();
        assertThat(name, equalTo("springResourceAware"));
    }

    @Test
    public void testFactory() {
        BeanFactory factory = getAware().getFactory();

        assertNotNull(factory);

        assertNotNull(factory.getBean(SpringResourceAware.class));
    }

    @Test
    public void testMessageSource() {
        Object[] args = new Object[] { "jack" };
        SpringResourceAware aware = getAware();

        assertThat(aware.getEnglishMsg(args), equalTo("Thank you, jack"));
        assertThat(aware.getChineseMsg(args), equalTo("谢谢你, jack"));
    }

    @Test
    public void testPublisher() {
        assertNotNull(getAware().getPublisher());
    }

    @After
    public void destory() {
        context.close();
    }
}
