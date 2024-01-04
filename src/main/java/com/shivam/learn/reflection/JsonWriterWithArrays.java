package com.shivam.learn.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @author sksingh created on 12/12/23
 */
public class JsonWriterWithArrays {

    public static void main(String[] args) throws IllegalAccessException {
        Person.Address address = new Person.Address("Bangalore", "Haralur", (short) 41);

        Person person = new Person("Vishal", 21, 220.45f, 100d, new int[]{100, 650}, address);

        System.out.println(objectToJson(person));
    }

    private static String objectToJson(Object instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            if (field.isSynthetic()) {
                continue;
            }

            field.setAccessible(true);
            sb.append(formatStringValue(field.getName()));
            sb.append(":");

            if (field.getType().isPrimitive()) {
                sb.append(formatPrimitiveValue(field.getType(), field.get(instance)));
            } else if (field.getType().equals(String.class)) {
                sb.append(formatStringValue(field.get(instance).toString()));
            } else if (field.getType().isArray()) {
                sb.append(formatArrayValue(field.get(instance)));
            } else {
                sb.append(objectToJson(field.get(instance)));
            }

            if (i != fields.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    private static String formatArrayValue(Object o) throws IllegalAccessException {
        Class<?> type = o.getClass().componentType();
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < Array.getLength(o); i++) {
            if (type.isPrimitive()) {
                sb.append(formatPrimitiveValue(type, Array.get(o, i)));
            } else if (type.equals(String.class)) {
                sb.append(formatStringValue(Array.get(o, i).toString()));
            } else {
                sb.append(objectToJson(o));
            }

            if (i != Array.getLength(o) - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }


    private static String formatPrimitiveValue(Class<?> type, Object value) {
        if (type.equals(boolean.class)
                || type.equals(int.class)
                || type.equals(short.class)
                || type.equals(byte.class)
                || type.equals(long.class)
        ) {
            return value.toString();
        } else if (type.equals(float.class) || type.equals(double.class)) {
            return String.format("%.02f", value);
        }

        throw new RuntimeException(String.format("Type: %s is unsupported", type.getName()));
    }

    private static String formatStringValue(String value) {
        return String.format("\"%s\"", value);
    }

}
