package com.shivam.learn.reflection.annotation.http;

import com.shivam.learn.reflection.annotation.annotations.InitializerClass;
import com.shivam.learn.reflection.annotation.annotations.InitializerMethod;

/**
 * @author sksingh created on 14/01/24
 */
@InitializerClass
public class ServiceRegistry {

    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
