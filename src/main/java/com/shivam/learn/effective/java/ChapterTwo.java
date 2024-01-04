package com.shivam.learn.effective.java;

import java.util.Comparator;

public class ChapterTwo implements Comparator<ChapterTwo> {
    //Consider static factory method instead of constructors

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        //BigInteger.probablePrime()
        //Flyweight pattern
        //interface-based frameworks
        //static factory methods for an interface named Type were put in a non-instantiable companion class
    }

    @Override
    public int compare(ChapterTwo o1, ChapterTwo o2) {
        return 0;
    }

    // A second shortcoming of static factory methods is that they are hard for programmers to find.
    // Here are some common names for static factory methods.
    //from
    //of

    //instance or getInstance - returns an instance that s described by its parameters (if any)
}
