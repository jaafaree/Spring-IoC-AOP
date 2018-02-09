package com.github.jaafar.IoC2.factory;

import com.github.jaafar.IoC2.BeanDefinition;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:19
 */
public interface BeanFactory {
    Object getBean(String name);
    void registerBean(String name, BeanDefinition beanDefinition);
}
