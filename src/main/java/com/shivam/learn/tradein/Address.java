package com.shivam.learn.tradein;

import lombok.Data;

@Data
public class Address {

    private String line1;
    private String city;
    private String state;
    private Long zipCode; // user zipCode
    private String country;
}
