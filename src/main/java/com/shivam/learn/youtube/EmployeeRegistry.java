package com.shivam.learn.youtube;

public interface EmployeeRegistry {

    enum PhoneType {
        HOME, MOBILE, OFFICE;
    }

    PhoneBook getPhoneBooK();

}
