package com.shivam.learn.lomboktest;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * @author sksingh created on 15/11/23
 */
@Data
@FieldNameConstants
public class Person {

    private String name;
    private Integer age;
    private Address address;

    public static class Address {

        private String city;
        private String state;
        private String country;

    }
}
