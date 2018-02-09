package com.github.jaafar.IoC4;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 13:54
 */
public class PropertyValue {
    private final String key;
    private final String value;

    public PropertyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
