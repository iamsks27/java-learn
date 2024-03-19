package com.shivam.learn.lomboktest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sksingh created on 06/02/24
 */
public class Test {

    public static void main(String[] args) {
//        LoginResult loginResult = new LoginResult();
//
//        loginResult.setAuthToken(null);

        List<String> names = List.of("Shivam", "Priyanka");

        List<String> capitalNames = names.stream()
                .map(String::toUpperCase)
                .toList();


        System.out.println(capitalNames);

    }
}
