package com.shivam.learn.youtube;

import java.util.ArrayList;
import java.util.List;

public class MyCustomList<T> {

    List<T> list = new ArrayList<>();

    public void addElement(T element) {
        list.add(element);
    }

    public void deleteElement(T element) {
        list.remove(element);
    }

    public T get(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
