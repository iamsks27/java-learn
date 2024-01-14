package com.shivam.learn.reflection.annotation;

import com.shivam.learn.reflection.annotation.annotations.InitializerClass;
import com.shivam.learn.reflection.annotation.annotations.InitializerMethod;

/**
 * @author sksingh created on 14/01/24
 */
@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void  startAutoSavingThreads() {
        System.out.println("Start automatic data saving to disk");
    }
}
