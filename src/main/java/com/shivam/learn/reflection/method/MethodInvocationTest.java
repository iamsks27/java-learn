package com.shivam.learn.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sksingh created on 04/01/24
 */
public class MethodInvocationTest {

    public void test() {
        System.out.println("Hello, there!!!");
    }

    public static void staticTest() {
        System.out.println("Hello, static there!!!");
    }

    public static void main(
            String[] args
    ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<MethodInvocationTest> methodInvocationTestClass = MethodInvocationTest.class;

        Method method = methodInvocationTestClass.getMethod("test");

        method.invoke(methodInvocationTestClass.getConstructor().newInstance());

        Method method1 = methodInvocationTestClass.getMethod("staticTest");
        method1.invoke(null);
    }
}
