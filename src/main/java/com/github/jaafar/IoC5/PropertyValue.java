package com.github.jaafar.IoC5;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 13:54
 */
public class PropertyValue {
    private final String key;
    private final Object value;

    public PropertyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
