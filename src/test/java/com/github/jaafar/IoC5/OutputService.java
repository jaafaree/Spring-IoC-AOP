package com.github.jaafar.IoC5;

import org.junit.Assert;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 23:05
 */
public class OutputService {

    private SayService sayService;

    public void output(String text) {
        Assert.assertNotNull(sayService);
        System.out.println("text = [" + text + "]");
    }

    public void setSayService(SayService sayService) {
        this.sayService = sayService;
    }
}
