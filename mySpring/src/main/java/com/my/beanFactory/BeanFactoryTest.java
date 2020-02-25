package com.my.beanFactory;


import com.my.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");
        System.out.println(resource.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);//通过resource装载spring配置信息，启动IoC容器

        System.out.println("init BeanFactory");

        Car car = factory.getBean("car", Car.class);//工厂从容器中获取bean
        System.out.println("car bean is ready for user!");
        car.introduce();
    }
}
