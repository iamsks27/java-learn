package com.shivam.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sksingh created on 03/12/23
 */
public class DependencyInjectTest {

    public static void main(
            String[] args
    ) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<?>[] constructors = D.class.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];

        Arrays.stream(constructors)
                .forEach(System.out::println);

        DependencyInjectTest dependencyInjectTest = new DependencyInjectTest();
        C c = dependencyInjectTest.new C();
        B b = dependencyInjectTest.new B(c);
        A a = dependencyInjectTest.new A(b);

        // D d = dependencyInjectTest.new D(a, b, c);

        constructor.setAccessible(true);
        // Inner class need object of out class during instantiation.
        Object d = constructor.newInstance(dependencyInjectTest, a, b, c);

        System.out.println(d);
        // createObjectRecursively(D.class);
    }

    private static <T> T createObjectRecursively(
            Class<T> clazz
    ) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getFirstConstructor(clazz);

        List<Object> constructorArguments = new ArrayList<>();

        for (Class<?> parameterType : constructor.getParameterTypes()) {
            Object argumentVal = createObjectRecursively(parameterType);
            constructorArguments.add(argumentVal);
        }

        constructor.setAccessible(true);

        return (T) constructor.newInstance(constructorArguments.toArray());
    }

    private static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        if (constructors.length == 0) {
            throw new IllegalStateException(
                    String.format("No constructor has been found for class %s", clazz.getName()));
        }

        return constructors[0];
    }

    class A {

        B b;

        A(B b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "A";
        }
    }


    class B {

        C c;

        B(C c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "B";
        }
    }

    class C {

        @Override
        public String toString() {
            return "C";
        }
    }


    class D {

        A a;
        B b;
        C c;

        D(A a, B b, C c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "D";
        }
    }

}

