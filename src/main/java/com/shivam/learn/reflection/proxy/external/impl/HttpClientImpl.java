package com.shivam.learn.reflection.proxy.external.impl;

import com.shivam.learn.reflection.proxy.external.HttpClient;

public final class HttpClientImpl implements HttpClient {

    @Override
    public void initialise() {
        System.out.println("Initializing HTTP client");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String sendRequest(String request) {
        System.out.printf("Sending request %s%n", request);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received response");
        return "someResponse data";
    }
}