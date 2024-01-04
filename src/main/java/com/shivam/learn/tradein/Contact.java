package com.shivam.learn.tradein;

import lombok.Data;

@Data
public class Contact {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
