package com.github.jaafar.IoC2;

import com.github.jaafar.IoC2.factory.AutowiredCapableBeanFactory;
import com.github.jaafar.IoC2.factory.BeanFactory;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:39
 */
public class TestIoC2 {
    @Test
    public void test() {
        //初始化Beanfactory
        BeanFactory beanFactory = new AutowiredCapableBeanFactory();

        //bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.github.jaafar.IoC2.TestService");
        //注入bean
        beanFactory.registerBean("testService", beanDefinition);

        //获取bean
        TestService testService = (TestService) beanFactory.getBean("testService");
        testService.sayHi("aaaaa");


    }
}
