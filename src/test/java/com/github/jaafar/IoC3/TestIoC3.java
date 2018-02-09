package com.github.jaafar.IoC3;

import com.github.jaafar.IoC3.factory.AutowiredCapableBeanFactory;
import com.github.jaafar.IoC3.factory.BeanFactory;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 14:33
 */
public class TestIoC3 {

    @Test
    public void test() throws Exception {
        BeanFactory beanFactory = new AutowiredCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.github.jaafar.IoC3.TestService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("word", "Hello World!!!"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBean("testService", beanDefinition);


        TestService testService = (TestService) beanFactory.getBean("testService");
        testService.sayHi();
    }
}
