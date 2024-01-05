package com.shivam.learn.reflection;

import lombok.Data;

/**
 * @author sksingh created on 25/11/23
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> square = Class.forName("com.shivam.learn.reflection.ClassTest$Square");

        int x = 5;

        System.out.println(int.class);
        printClassInfo(Drawable.class, square, Color.class, String.class, int[][].class);
    }

    private static void printClassInfo(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            System.out.printf(
                    "class name: %s, class package name: %s%n",
                    clazz.getSimpleName(),
                    clazz.getPackageName()
            );

            Class<?>[] interfaces = clazz.getInterfaces();

            for (Class<?> anInterface : interfaces) {
                System.out.printf(
                        "class %s implements: %s\n",
                        clazz.getSimpleName(),
                        anInterface.getSimpleName()
                );
            }

            System.out.println("Is array: " + clazz.isArray());

            System.out.println();
            System.out.println();
        }
    }

    private static interface Drawable {

        int getNumberOfCorners();
    }

    @Data
    private static class Square implements Drawable {

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }
}
