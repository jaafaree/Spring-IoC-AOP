package com.github.jaafar.IoC4.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 15:52
 */
public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("something.xml");
        InputStream inputStream = resource.getInputStream();
        assertNotNull(inputStream);
    }

}
