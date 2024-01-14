package com.shivam.learn.reflection.annotation.databases;

import com.shivam.learn.reflection.annotation.annotations.InitializerClass;
import com.shivam.learn.reflection.annotation.annotations.InitializerMethod;

/**
 * @author sksingh created on 14/01/24
 */
@InitializerClass
public class CacheLoader {

    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }

    public void reloadCache() {
        System.out.println("Reload cache");
    }
}
