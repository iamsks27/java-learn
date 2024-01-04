package com.shivam.learn.reflection.polymorphism.logging;

/**
 * @author sksingh created on 04/01/24
 */
public class FileLogger {

    public void sendRequest(String data) {
        System.out.printf("Data: %s was logged to the file system\n", data);
    }

}
