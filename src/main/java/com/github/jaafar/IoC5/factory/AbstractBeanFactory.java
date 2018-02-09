package com.github.jaafar.IoC5.factory;

import com.github.jaafar.IoC5.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = this.beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBeanInstance(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBean(String name, BeanDefinition beanDefinition) throws Exception {
        this.beanDefinitionMap.put(name, beanDefinition);
        this.beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    protected abstract Object doCreateBeanInstance(BeanDefinition beanDefinition) throws Exception;
}
