package com.github.jaafar.IoC6.beans.factory;

import com.github.jaafar.IoC6.beans.BeanDefinition;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:19
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
