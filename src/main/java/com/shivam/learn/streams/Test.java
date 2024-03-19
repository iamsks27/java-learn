package com.shivam.learn.streams;

import java.util.List;

import static com.shivam.learn.streams.StreamUtil.zip;

/**
 * @author sksingh created on 06/02/24
 */
public class Test {

    public static void main(String[] args) {
        List<String> list1 = List.of("JDK 1.0", "J2SE 1.2");
        List<Integer> list2 = List.of(1996, 1998);

        zip(list1, list2, (jdk, year) -> jdk + " was release in " + year)
                .forEach(System.out::println);
    }

}
