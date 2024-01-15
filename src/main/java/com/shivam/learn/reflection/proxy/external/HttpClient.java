package com.shivam.learn.reflection.proxy.external;

/**
 * @author sksingh created on 15/01/24
 */
public interface HttpClient {

    void initialise();

    String sendRequest(String request);
}
