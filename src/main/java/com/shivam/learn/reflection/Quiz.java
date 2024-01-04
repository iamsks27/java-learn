package com.shivam.learn.reflection;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sksingh created on 03/12/23
 */
public class Quiz {

    private static final int[] ages = {20, 40, 49, 24, 19};
    private static final String TEXT = "{\"deliveryFee\":\"ten\"}";

    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        List<Person> persons = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            Person person = new Person();
//            person.setName("Vishal");
//            person.setAge(ages[i]);
//
//            persons.add(person);
//            if (person.getAge() % 2 == 0) {
//                Person person2 = new Person();
//                person2.setName("Aditya");
//                person2.setAge(ages[i]);
//                persons.add(person2);
//            }
//
//        }
//
//
//        System.out.println(persons);

        ObjectMapper objectMapper = new ObjectMapper();

        Test test = objectMapper.readValue(TEXT, Test.class);


        System.out.println(test);
    }


    @Data
    static class Test {
        private BigDecimal deliveryFee;
    }

    @Data
    static class Person {

        String name;
        int age;
    }
}
