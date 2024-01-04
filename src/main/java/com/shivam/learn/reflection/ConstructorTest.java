package com.shivam.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sksingh created on 25/11/23
 */
public class ConstructorTest {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // printConstructorData(Person.class);

        Person person = (Person) createInstanceWithArguments(Person.class);
        Person person2 = createInstanceWithArgumentsWithGenerics(Person.class, "Alex");
        System.out.println(person);
        System.out.println(person2);
    }

    private static <T> T createInstance(Class<T> clazz, Object... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?>[] parameterTypes = Arrays.stream(args)
                .map(Object::getClass)
                .toArray(Class[]::new);

        Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);

        return (T) constructor.newInstance(args);
    }

    @SuppressWarnings("unchecked")
    private static <T> T createInstanceWithArgumentsWithGenerics(Class<T> clazz, Object... args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == args.length) {
                return (T) constructor.newInstance(args);

            }
        }

        System.out.println("An appropriate constructor wasn't found");
        return null;
    }

    private static Object createInstanceWithArguments(Class<?> clazz, Object... args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == args.length) {
                return constructor.newInstance(args);

            }
        }

        System.out.println("An appropriate constructor wasn't found");
        return null;
    }

    private static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        System.out.printf("class %s has %d declared constructors\n", clazz.getSimpleName(), constructors.length);

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(Class::getSimpleName)
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }
    }

    private static class Person {

        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.address = null;
            this.age = 0;
            this.name = "Anonymous";
        }

        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(String name, int age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private record Address(String street, int number) {

    }
}
