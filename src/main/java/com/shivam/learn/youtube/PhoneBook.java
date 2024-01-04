package com.shivam.learn.youtube;

import com.shivam.learn.youtube.EmployeeContacts.EmptyContacts;

import java.util.Map;
import java.util.Optional;

public class PhoneBook {

    private Map<String, EmployeeContacts> contacts;

    public EmployeeContacts getEmployeeContacts(String name) {
        return Optional //
                .ofNullable(contacts.get(name)) //
                .orElse(EmptyContacts.INSTANCE);
    }
}
