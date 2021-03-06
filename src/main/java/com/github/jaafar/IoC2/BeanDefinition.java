package com.github.jaafar.IoC2;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 12:20
 */
public class BeanDefinition {
    private Object bean;
    private Class beanClass;
    private String beanClassName;

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
