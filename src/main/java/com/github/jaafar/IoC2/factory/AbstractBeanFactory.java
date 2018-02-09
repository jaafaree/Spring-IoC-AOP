package com.github.jaafar.IoC2.factory;

import com.github.jaafar.IoC2.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:21
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) {
        return this.beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBean(String name, BeanDefinition beanDefinition) {
        Object beanInstance = doCreateBeanInstance(beanDefinition);
        beanDefinition.setBean(beanInstance);
        this.beanDefinitionMap.put(name, beanDefinition);
    }

    protected abstract Object doCreateBeanInstance(BeanDefinition beanDefinition);
}
