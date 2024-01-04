package com.shivam.learn.designingjavaapi;

import java.util.Collection;

/**
 * @author sksingh created on 28/08/23
 */
public class Person {

    private String address;
    private Collection<Person> siblings;

    public Person(String address, Collection<Person> siblings) {
        this.address = address;
        this.siblings = siblings;
    }

    public String getAddress() {
        return address;
    }

    public Collection<Person> getSiblings() {
        return siblings;
    }
}
