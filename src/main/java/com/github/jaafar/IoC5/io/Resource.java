package com.github.jaafar.IoC5.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 15:09
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
