package com.github.jaafar.IoC4.factory;

import com.github.jaafar.IoC4.BeanDefinition;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:19
 */
public interface BeanFactory {
    Object getBean(String name);
    void registerBean(String name, BeanDefinition beanDefinition) throws Exception;
}
