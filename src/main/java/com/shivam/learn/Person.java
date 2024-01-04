package com.shivam.learn;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

public record Person(
        String name,
        int age,
        BigDecimal salary
) {

    public Person(String name, int age) {
        this(name, age, null);
    }

    public Person(String name, int age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static void main(String[] args) {
        final List<Person> persons = new ArrayList<>();

        final Optional<Integer> age = persons.stream().findFirst().map(Person::age);

        age.ifPresent(System.out::println);

        BigDecimal salary = BigDecimal.ZERO;
        for (int i = 0; i < 5; i++) {
            persons.add(new Person("IAM - " + i, i + 10, salary));
        }


        BigDecimal total = persons.stream()
                .map(Person::salary)
                .reduce(null, Person::addTotalPrice);

        System.out.println(total);
    }

    private static BigDecimal addTotalPrice(BigDecimal toAdd, BigDecimal total) {
        if (toAdd != null) {
            return nonNullBigDecimal(total).add(toAdd);
        }

        return total;
    }

    private static BigDecimal nonNullBigDecimal(BigDecimal total) {
        return nonNull(total) ? total : BigDecimal.ZERO;
    }
}
