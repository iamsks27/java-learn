package com.shivam.learn.optionaltest;

import com.shivam.learn.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        /*
        final Map<String, Person> persons = new HashMap<>();

        final Person person = new Person("Shivam", 30);

        System.out.println(Optional
                                   .of(person)
                                   .map(Person::getName)
                                   .map(persons::get)
                                   .map(Test::getPersonAge)
                                   .orElse(1));

         */
//        final List<List<Person>> persons = new ArrayList<>();
//        persons.add(Arrays.asList( //
//                                   new Person("John", 40), //
//                                   new Person("Jackson", 39), //
//                                   new Person("Jimmy", 45)));
//
//        final List<String> names = persons
//                .stream()
//                .flatMap(Test::getFilteredPersons)
//                .collect(Collectors.toList());
//
//        System.out.println(names);

//        System.out.println(getId(null, null));
//        System.out.println(getId("xyz", null));
//        System.out.println(getId(null, "abc"));
//        System.out.println(getId("", "jkl"));
//        System.out.println(getId("qwe", ""));

//        Person person = null;
//        final String msg = Optional.ofNullable(person)
//                .filter(Test::isApplicable)
//                .map(Test::format)
//                .orElse("Hello, Tekion");
//
//        System.out.println(msg);

//        final List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
//
//        System.out.println(numbers.stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList()));

        List<Integer> list = Arrays.asList(10, 9, 8, 4, 9);

//        Set<Integer> collect = list.stream()
//                .collect(Collectors.toCollection(TreeSet::new));

//        List<Integer> collect = list.stream()
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//
//
//        System.out.println(collect);


        final List<String> names = new ArrayList<>();

        names.stream()
                .map(Test::change)
                .collect(Collectors.toList());

        System.out.println(names);


        for (String ignored : args) {
            System.out.println("Yet another argument!!!");
        }

    }

    private static String change(String s) {
        System.out.println("Hello there!!!!");
        return s.toUpperCase();
    }

    private static boolean isApplicable(final Person person) {
        return false;
    }

    private static Stream<String> getFilteredPersons(List<Person> persons) {
        return persons
                .stream()
                .filter(person -> 39 < person.age())
                .map(Person::name)
                .map(String::toUpperCase);
    }

    private static int getPersonAge(Person p) {
        System.out.println("This is called");
        return p.age();
    }

    private static String getId(String name, String code) {
        return Optional.ofNullable(code)
                .map(c -> name + "|" + code)
                .orElse(name);
    }

    private static boolean isApplicable() {
        return false;
    }

    private static String format(Person person) {
        return "Hello, World";
    }
}
