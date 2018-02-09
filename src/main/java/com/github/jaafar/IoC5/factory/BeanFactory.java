package com.github.jaafar.IoC5.factory;

import com.github.jaafar.IoC5.BeanDefinition;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:19
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
    void registerBean(String name, BeanDefinition beanDefinition) throws Exception;
}
