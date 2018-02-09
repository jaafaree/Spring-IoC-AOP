package com.github.jaafar.IoC4;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 13:55
 */
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        if (propertyValueList.indexOf(propertyValue) == -1){
            this.propertyValueList.add(propertyValue);
        }
    }

    public List<PropertyValue> getPropertyValueList() {
        return this.propertyValueList;
    }
}
