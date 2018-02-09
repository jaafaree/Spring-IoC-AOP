package com.github.jaafar.IoC5;

import com.github.jaafar.IoC5.factory.AbstractBeanFactory;
import com.github.jaafar.IoC5.factory.AutowiredCapableBeanFactory;
import com.github.jaafar.IoC5.io.ResourceLoader;
import com.github.jaafar.IoC5.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 23:04
 */
public class BeafactoryTest {

    @Test
    public void testLazy() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadDefinitions("something2.xml");

        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        SayService sayService = (SayService) beanFactory.getBean("sayService");
        sayService.say();
    }

    @Test
    public void testInstantiate() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadDefinitions("something2.xml");

        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        beanFactory.preInstantiateSingletons();

        SayService sayService = (SayService) beanFactory.getBean("sayService");
        sayService.say();
    }
}
