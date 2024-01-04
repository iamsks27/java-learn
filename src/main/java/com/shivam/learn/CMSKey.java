package com.shivam.learn;

public enum CMSKey {

    X(String.class),
    Y(Integer.class);

    private Class clazz;

    CMSKey(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
