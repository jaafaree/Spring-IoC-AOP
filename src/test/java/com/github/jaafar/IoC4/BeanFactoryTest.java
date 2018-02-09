package com.github.jaafar.IoC4;

import com.github.jaafar.IoC4.factory.AutowiredCapableBeanFactory;
import com.github.jaafar.IoC4.factory.BeanFactory;
import com.github.jaafar.IoC4.io.ResourceLoader;
import com.github.jaafar.IoC4.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * 现在有一个大问题没有解决：我们无法处理bean之间的依赖，无法将bean注入到bean中，
 * 所以它无法称之为完整的IoC容器！
 * 如何实现呢？
 * 我们定义一个BeanReference，来表示这个属性是对另一个bean的引用。
 * 这个在读取xml的时候初始化，并在初始化bean的时候，进行解析和真实bean的注入。
 *
 * @author jaafaree
 * @create 2018/2/9 15:59
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        //读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadDefinitions("something.xml");

        //init BeanFactory注册bean
        BeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinition :
                xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBean(beanDefinition.getKey(), beanDefinition.getValue());
        }

        TestService testService = (TestService) beanFactory.getBean("testService");
        testService.sayHi();
    }
}
