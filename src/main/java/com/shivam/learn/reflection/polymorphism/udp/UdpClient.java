package com.shivam.learn.reflection.polymorphism.udp;

/**
 * @author sksingh created on 04/01/24
 */
public class UdpClient {

    public void sendAndForget(String requestPayload) {
        System.out.printf("Request: %s was sent through UDP\n", requestPayload);
    }
}
