package com.github.jaafar.IoC4.xml;

import com.github.jaafar.IoC4.BeanDefinition;
import com.github.jaafar.IoC4.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 15:56
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadDefinitions("something.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        assert registry.size() == 1;
    }
}
