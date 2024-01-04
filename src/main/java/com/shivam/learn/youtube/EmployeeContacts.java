package com.shivam.learn.youtube;

import com.shivam.learn.youtube.EmployeeRegistry.PhoneType;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeeContacts {

    private Map<PhoneType, List<String>> numbers;

    public List<String> getNumbers(PhoneType type) {
        return Optional.ofNullable(numbers.get(type)).orElse(Collections.emptyList());
    }

    public static EmptyContacts INSTANCE = new EmptyContacts();

    static class EmptyContacts extends EmployeeContacts {

        @Override
        public List<String> getNumbers(PhoneType type) {
            return Collections.emptyList();
        }
    }
}
