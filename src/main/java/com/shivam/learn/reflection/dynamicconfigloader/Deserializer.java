package com.shivam.learn.reflection.dynamicconfigloader;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author sksingh created on 12/12/23
 */
public class Deserializer {

    private static final System.Logger LOGGER = System.getLogger(Deserializer.class.getName());
    private static final Path GAME_CONFIG = Path.of(
            "/Users/sksingh/Documents/code/java/src/main/resources/game-properties.cfg");
    private static final Path USER_INTERFACE = Path.of(
            "/Users/sksingh/Documents/code/java/src/main/resources/user-interface.cfg");

    public static void main(
            String[] args
    ) throws URISyntaxException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        System.out.println(createConfigObject(GameConfig.class, GAME_CONFIG));
        System.out.println(createConfigObject(UserInterface.class, USER_INTERFACE));
    }

    private static <T> T createConfigObject(
            Class<T> clazz, Path filePath
    ) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(filePath);

        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        T configInstance = constructor.newInstance();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] fields = line.split("=");

            if (fields.length != 2) {
                continue;
            }

            String fieldName = fields[0];
            String fieldValue = fields[1];

            Field field;
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                LOGGER.log(System.Logger.Level.ERROR, String.format("Property name: %s is unsupported", fieldName));
                continue;
            }

            field.setAccessible(true);

            Object parsedValue;
            if (field.getType().isArray()) {
                parsedValue = parseArray(field.getType(), fieldValue);
            } else {
                parsedValue = parseValue(field.getType(), fieldValue);
            }

            field.set(configInstance, parsedValue);
        }

        return configInstance;
    }

    private static Object parseValue(Class<?> type, String fieldValue) {
        if (type.equals(int.class)) {
            return Integer.parseInt(fieldValue);
        } else if (type.equals(short.class)) {
            return Short.parseShort(fieldValue);
        } else if (type.equals(boolean.class)) {
            return Boolean.parseBoolean(fieldValue);
        } else if (type.equals(double.class)) {
            return Double.parseDouble(fieldValue);
        } else if (type.equals(long.class)) {
            return Long.parseLong(fieldValue);
        } else if (type.equals(String.class)) {
            return fieldValue;
        } else {
            return Float.parseFloat(fieldValue);
        }
    }

    private static Object parseArray(Class<?> elementType, String fieldValue) {
        String[] fields = fieldValue.split(",");

        Object arr = Array.newInstance(elementType, fields.length);

        for (int i = 0; i < fields.length; i++) {
            Array.set(arr, i, parseValue(elementType, fields[i]));
        }

        return arr;
    }

}
