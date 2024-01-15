package com.shivam.learn.reflection;

import java.lang.reflect.Field;

/**
 * @author sksingh created on 03/12/23
 */
public class FieldTest {

    public static void main(String[] args) throws IllegalAccessException {
        // This will generate synthetic field $VALUES in case of an enum class
        printDeclaredFieldsInfo(Category.class);

        Movie movie = new Movie(
                "Lord of the rings",
                2002,
                true,
                Category.ADVENTURE,
                12.99
        );

        printDeclaredFieldsInfo(Movie.class, movie);
    }

    public static void printDeclaredFieldsInfo(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.printf("Field name: %s, type: %s\n", field.getName(), field.getType());
            System.out.printf("Is synthetic field: %s\n", field.isSynthetic());
            System.out.println();
        }
    }
    public static <T> void printDeclaredFieldsInfo(Class<? extends T> clazz, T instance) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.printf("Field name: %s, type: %s\n",
                              field.getName(), field.getType());
            System.out.printf("Is synthetic field: %s\n", field.isSynthetic());
            System.out.printf("Field value: %s\n", field.get(instance));
            System.out.println();
        }
    }

    public static class Movie extends Product {

        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, boolean isReleased, Category category, double actualPrice) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = Math.max(actualPrice, MINIMUM_PRICE);
        }
    }

    public static class Product {

        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }

    public enum Category {

        ADVENTURE,
        ACTION,
        COMEDY
    }

}
