package com.shivam.learn.reflection.polymorphism.database;

/**
 * @author sksingh created on 04/01/24
 */
public class DatabaseClient {

    public boolean storeData(String data) {
        System.out.printf("Data: %s was successfully stored in the database%n", data);

        return true;
    }

}
