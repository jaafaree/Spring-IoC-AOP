package com.github.jaafar.IoC6.context;

import com.github.jaafar.IoC6.beans.factory.AbstractBeanFactory;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 23:51
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return this.beanFactory.getBean(name);
    }
}
