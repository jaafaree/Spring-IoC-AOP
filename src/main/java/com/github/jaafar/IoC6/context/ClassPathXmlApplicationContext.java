package com.github.jaafar.IoC6.context;

import com.github.jaafar.IoC6.beans.BeanDefinition;
import com.github.jaafar.IoC6.beans.factory.AbstractBeanFactory;
import com.github.jaafar.IoC6.beans.factory.AutowiredCapableBeanFactory;
import com.github.jaafar.IoC6.beans.io.ResourceLoader;
import com.github.jaafar.IoC6.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 23:54
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configuration;

    public ClassPathXmlApplicationContext(String configuration) throws Exception {
        this(new AutowiredCapableBeanFactory(), configuration);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configuration) throws Exception {
        super(beanFactory);
        this.configuration = configuration;
        this.refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadDefinitions(this.configuration);

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            super.beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
