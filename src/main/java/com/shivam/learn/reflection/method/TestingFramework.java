package com.shivam.learn.reflection.method;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingFramework {

    public void runTestSuite(Class<?> testClass) throws Throwable {
        /**
         * Complete your code here
         */

        Method[] methods = testClass.getMethods();

        Method beforeClassMethod = findMethodByName(methods, "beforeClass");
        if (beforeClassMethod != null) {
            beforeClassMethod.invoke(null);
        }

        Method setupTestMethod = findMethodByName(methods, "setupTest");
        List<Method> testMethods = findMethodsByPrefix(methods, "test");
        Object object = testClass.getDeclaredConstructor().newInstance();

        for (Method testMethod : testMethods) {
            if (setupTestMethod != null) {
                setupTestMethod.invoke(object);
            }
            testMethod.invoke(object);
        }

        Method afterClassMethod = findMethodByName(methods, "afterClass");
        if (afterClassMethod != null) {
            afterClassMethod.invoke(null);
        }
    }

    /**
     * Helper method to find a method by name
     * Returns null if a method with the given name does not exist
     */
    private Method findMethodByName(Method[] methods, String name) {
        /**
         * Complete your code here
         */
        Method res = null;
        for (Method method : methods) {
            if (method.getName().equals(name) &&
                    method.getParameterCount() == 0 &&
                    method.getReturnType().equals(void.class)) {
                res = method;
                break;
            }
        }

        return res;
    }

    /**
     * Helper method to find all the methods that start with the given prefix
     */
    private List<Method> findMethodsByPrefix(Method[] methods, String prefix) {
        /**
         * Complete your code here
         */
        List<Method> methodWithPrefix = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith(prefix) &&
                    method.getParameterCount() == 0 &&
                    method.getReturnType().equals(void.class)) {
                methodWithPrefix.add(method);
            }
        }

        return methodWithPrefix;
    }
}