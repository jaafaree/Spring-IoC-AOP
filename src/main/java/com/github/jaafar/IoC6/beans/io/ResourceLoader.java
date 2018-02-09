package com.github.jaafar.IoC6.beans.io;

import java.net.URL;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 15:14
 */
public class ResourceLoader {
    public Resource getResource(String localtion) {
        URL resource = this.getClass().getClassLoader().getResource(localtion);
        return new UrlResource(resource);
    }
}
