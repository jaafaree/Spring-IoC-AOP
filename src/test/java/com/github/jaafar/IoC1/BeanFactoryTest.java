package com.github.jaafar.IoC1;

import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 11:57
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        //初始化bean工厂
        BeanFactory beanFactory = new BeanFactory();

        //向bean工厂中注入bean
        TestService bean = new TestService();
        System.out.println(bean.hashCode());
        BeanDefinition beanDefinition = new BeanDefinition(bean);
        beanFactory.registerBean("testService", beanDefinition);

        //从bean工厂中获取bean实例
        TestService testService = (TestService) beanFactory.getBean("testService");
        System.out.println(testService.hashCode());
        assert testService.hashCode() == bean.hashCode();
        testService.sayHi("11111");

    }
}
