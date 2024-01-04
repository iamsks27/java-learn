package com.shivam.learn.effective.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Elvis {

    private static final Map<String, Elvis> INSTANCES = new HashMap<>();

    private Elvis() {}

    public static Elvis getInstance() {
        final String tName = Thread.currentThread().getName();
        INSTANCES.computeIfAbsent(tName, t -> new Elvis());

        return INSTANCES.get(tName);
    }


}
