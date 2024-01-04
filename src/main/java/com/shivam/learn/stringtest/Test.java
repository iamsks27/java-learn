package com.shivam.learn.stringtest;

import java.util.Objects;

public class Test {

    public static void main(String[] args) {
        System.out.println(getId("Shivam", "007"));
        System.out.println(getId(null, "007"));
        System.out.println(getId("", "007"));
        System.out.println(getId("Shivam", ""));
        System.out.println(getId("Shivam", null));
    }

    public static String getId(String name, String code) {
        return Objects.isNull(code) ? name : String.join("|", name, code);
    }

}
