package com.shivam.learn;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

enum InventorySearchField {
    emi, downPayment, paymentType, annualMileage, creditScore, cash, zipcode, radius;

    private static final Set<String> NAMES = new HashSet<>();

    public static InventorySearchField fromValue(String value) {
        for (InventorySearchField field : InventorySearchField.values()) {
            if (field.name()
                     .equals(value)) {
                return field;
            }
        }

        return null;
    }

    public static Collection<String> names() {
        if (NAMES.size() == 0) {
            System.out.println("Called...");
            for (InventorySearchField field : InventorySearchField.values()) {
                NAMES.add(field.name());
            }
        }
        return NAMES;
    }
}

public class EnumTest {

    public static void main(String[] args) {
        InventorySearchField emi = InventorySearchField.valueOf("emi");
        System.out.println(emi);
        System.out.println(InventorySearchField.names());
        System.out.println(InventorySearchField.names());
        System.out.println(InventorySearchField.names());
    }
}
