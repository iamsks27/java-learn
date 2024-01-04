package com.shivam.learn.reflection;

/**
 * @author sksingh created on 12/12/23
 */
public class Person {

    private final String name;
    private final int age;
    private final float salary;
    private final double arial;

    private final int[] employeeIds;

    private final Address address;

    public Person(String name, int age, float salary, double arial, int[] employeeIds, Address address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.arial = arial;
        this.employeeIds = employeeIds;
        this.address = address;
    }


    public static class Address {
        private final String city;
        private final String street;
        private final short lane;

        public Address(String city, String street, short lane) {
            this.city = city;
            this.street = street;
            this.lane = lane;
        }
    }

}
