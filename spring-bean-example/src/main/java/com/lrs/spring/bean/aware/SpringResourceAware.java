package com.lrs.spring.bean.aware;

import org.apache.commons.io.IOExceptionWithCause;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

@Component
public class SpringResourceAware implements ResourceLoaderAware,BeanNameAware,BeanFactoryAware,MessageSourceAware,ApplicationEventPublisherAware {

    private ResourceLoader resourceLoader;
    /**
     * 加载外部资源使用
     * @see  org.springframework.context.ResourceLoaderAware
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private String beanName;

    /**
     *  获取类实例的bean name
     * @see org.springframework.beans.factory.BeanNameAware
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    private BeanFactory factory;

    /**
     * 获取当前bean的BeanFactory
     *
     * @see org.springframework.beans.factory.BeanFactoryAware
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = beanFactory;
    }

    private MessageSource messageSource;

    /**
     *
     *@see org.springframework.context.MessageSourceAware
     */
    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private ApplicationEventPublisher publisher;

    /**
     *  获取容器事件发布器
     * @see org.springframework.context.ApplicationEventPublisherAware
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public String  getResource() throws IOException {
        return IOUtils.toString(resourceLoader.getResource("classpath:common-cli.txt").getURI());
    }

    public String getBeanName() {
        return beanName;
    }

    public BeanFactory getFactory() {
        return factory;
    }

    public String getEnglishMsg(Object[] args){
        return messageSource.getMessage("msg",args, Locale.US);
    }

    public String getChineseMsg(Object[] args){
        return messageSource.getMessage("msg",args,Locale.CHINA);
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }
}
