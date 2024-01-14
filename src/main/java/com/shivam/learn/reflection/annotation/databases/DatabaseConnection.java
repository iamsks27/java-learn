package com.shivam.learn.reflection.annotation.databases;

import com.shivam.learn.reflection.annotation.annotations.InitializerClass;
import com.shivam.learn.reflection.annotation.annotations.InitializerMethod;

/**
 * @author sksingh created on 14/01/24
 */
@InitializerClass
public class DatabaseConnection {

    @InitializerMethod
    public void connectToDB1() {
        System.out.println("Connecting to database 1");
    }

    @InitializerMethod
    public void connectToDB2() {
        System.out.println("Connecting to database 2");
    }
}
