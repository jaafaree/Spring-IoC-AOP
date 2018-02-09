package com.github.jaafar.IoC4.xml;

import com.github.jaafar.IoC4.AbstractBeanDefinitionReader;
import com.github.jaafar.IoC4.BeanDefinition;
import com.github.jaafar.IoC4.PropertyValue;
import com.github.jaafar.IoC4.PropertyValues;
import com.github.jaafar.IoC4.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 15:19
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        // 从输入流读取xml中定义的bean
        doLoadDefinitions(inputStream);
    }

    protected void doLoadDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);
        Element documentElement = doc.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String name = element.getAttribute("name");
                String className = element.getAttribute("class");
                BeanDefinition beanDefinition = new BeanDefinition();
                NodeList properties = element.getElementsByTagName("property");
                for (int j = 0; j < properties.getLength(); j++) {
                    Node propertyNode = properties.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name1 = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        PropertyValues propertyValues = new PropertyValues();
                        PropertyValue propertyValue = new PropertyValue(name1, value);
                        propertyValues.addPropertyValue(propertyValue);
                        beanDefinition.setPropertyValues(propertyValues);
                    }
                }
                beanDefinition.setBeanClassName(className);
                super.getRegistry().put(name, beanDefinition);
            }
        }
        inputStream.close();
    }
}
