package com.github.jaafar.IoC4.factory;

import com.github.jaafar.IoC4.BeanDefinition;
import com.github.jaafar.IoC4.PropertyValue;

import java.lang.reflect.Field;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:36
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBeanInstance(BeanDefinition beanDefinition) throws Exception {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            beanDefinition.setBean(bean);
            applyPropertyValues(bean, beanDefinition);
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()){
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getKey());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
