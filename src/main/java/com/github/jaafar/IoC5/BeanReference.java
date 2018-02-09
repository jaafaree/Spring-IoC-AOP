package com.github.jaafar.IoC5;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 22:27
 */
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
