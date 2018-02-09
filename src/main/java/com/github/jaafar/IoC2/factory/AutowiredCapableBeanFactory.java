package com.github.jaafar.IoC2.factory;

import com.github.jaafar.IoC2.BeanDefinition;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:36
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBeanInstance(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
