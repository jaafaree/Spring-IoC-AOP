package com.github.jaafar.IoC6;

import com.github.jaafar.IoC6.context.ApplicationContext;
import com.github.jaafar.IoC6.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/10 0:10
 */
public class ApplicationContextTest {

    @Test
    public void testApplication() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("something3.xml");
        SayService sayService = (SayService) applicationContext.getBean("sayService");
        sayService.say();
    }

}
