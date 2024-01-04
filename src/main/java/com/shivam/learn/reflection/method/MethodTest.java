package com.shivam.learn.reflection.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author sksingh created on 19/12/23
 */
public class MethodTest {

    public static void main(String[] args) {
        testGetters(Product.class);
        testSetters(Product.class);
    }


    public static void testSetters(Class<?> dataClass) {
        Field[] fields = dataClass.getDeclaredFields();

        for (Field field : fields) {
            String setterName = "set" + capitalizeFirstLetter(field.getName());

            Method setterMethod;
            try {
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(String.format("Setter: %s not found", setterName));
            }

            if (!setterMethod.getReturnType().equals(void.class)) {
                throw new IllegalStateException(String.format("Setter method: %s has to return void", setterName));
            }
        }
    }

    public static void testGetters(Class<?> dataClass) {
        Field[] fields = dataClass.getDeclaredFields();

        Map<String, Method> nameToMethod = mapMethodNameToMethod(dataClass);

        for (Field field : fields) {
            String getterName = "get" + capitalizeFirstLetter(field.getName());

            if (!nameToMethod.containsKey(getterName)) {
                throw new IllegalStateException(
                        String.format("Field: %s doesn't have a getter method", field.getName()));
            }

            Method method = nameToMethod.get(getterName);
            if (!method.getReturnType().equals(field.getType())) {
                throw new IllegalStateException(
                        String.format(
                                "Getter method: %s() has return type %s but expected %s",
                                method.getName(),
                                method.getReturnType(),
                                field.getType()
                        )
                );
            }

            if (method.getParameterCount() > 0) {
                throw new IllegalStateException(
                        String.format("Getter %s() has %d arguments", method.getName(), method.getParameterCount()));
            }
        }
    }

    private static String capitalizeFirstLetter(String name) {
        return name.substring(0, 1).toUpperCase().concat(name.substring(1));
    }

    public static Map<String, Method> mapMethodNameToMethod(Class<?> clazz) {
        Method[] methods = clazz.getMethods();

        Map<String, Method> nameToMethod = new HashMap<>();
        for (Method method : methods) {
            nameToMethod.put(method.getName(), method);
        }

        return nameToMethod;
    }

    private static List<Field> getAllFields(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Field[] fields = clazz.getDeclaredFields();
        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());

        List<Field> allFields = new ArrayList<>(inheritedFields);

        Collections.addAll(allFields, fields);

        return allFields;
    }

    private static List<Constructor> getAllConstructor(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Constructor[] currentClassConstructor = clazz.getDeclaredConstructors();

        List<Constructor> inheritedConstructor = getAllConstructor(clazz.getSuperclass());

        List<Constructor> allConstructors = new ArrayList<>();
        allConstructors.addAll(Arrays.asList(currentClassConstructor));
        allConstructors.addAll(inheritedConstructor);

        return allConstructors;
    }
}
