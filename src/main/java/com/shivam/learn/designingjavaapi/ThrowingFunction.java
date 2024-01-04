package com.shivam.learn.designingjavaapi;

import java.io.IOException;

/**
 * @author sksingh created on 28/08/23
 */
@FunctionalInterface
public interface ThrowingFunction<T, R> {

    R apply(T t) throws IOException;

}
