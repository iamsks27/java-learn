package com.shivam.learn.reflection.annotation.databases;

import com.shivam.learn.reflection.annotation.annotations.InitializerClass;
import com.shivam.learn.reflection.annotation.annotations.InitializerMethod;
import com.shivam.learn.reflection.annotation.annotations.RetryOperation;

import java.io.IOException;

/**
 * @author sksingh created on 14/01/24
 */
@InitializerClass
public class DatabaseConnection {

    private int failCounter = 5;

    @InitializerMethod
    @RetryOperation(
            numberOfRetries = 10,
            retryExceptions = IOException.class,
            durationBetweenRetriesMs = 1_000,
            failureMessage = "Connection to database 1 failed after retries"
    )
    public void connectToDB1() throws IOException {
        System.out.println("Connecting to database 1");
        if (failCounter > 0) {
            failCounter--;
            throw new IOException("Connection Failed");
        }

        System.out.println("Connection to database1 succeeded");
    }

    @InitializerMethod
    public void connectToDB2() {
        System.out.println("Connecting to database 2");
    }
}
