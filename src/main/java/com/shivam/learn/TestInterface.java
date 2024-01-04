package com.shivam.learn;

import java.util.Random;

public interface TestInterface {

    default void printRandom() {
        int random = getRandomInt();

        System.out.println(random);
    }

    default int getRandomInt() {
        return new Random().nextInt();
    }
}


