package com.shivam.learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {

    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(new Person("R", 20), new Person("T", 21), new Person("S", 17));

        final List<Person> youngPeople = people
                .stream()
                .filter(p -> p.age() <= 18)
                .limit(10)
                .collect(Collectors.toList());

        youngPeople.forEach(System.out::println);

    }

}
