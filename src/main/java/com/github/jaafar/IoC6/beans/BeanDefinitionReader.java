package com.github.jaafar.IoC6.beans;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 15:04
 */
public interface BeanDefinitionReader {
    void loadDefinitions(String location) throws Exception;
}
