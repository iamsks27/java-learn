package com.shivam.learn.reflection.polymorphism.http;

/**
 * @author sksingh created on 04/01/24
 */
public class HttpClient {

    private String serverAddress;

    public HttpClient(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public boolean sendRequest(String data) {
        System.out.printf(
                "Request with body: %s was successfully sent to server with address: %s\n", data, serverAddress);

        return true;
    }
}
