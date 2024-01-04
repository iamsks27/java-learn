package com.shivam.learn.reflection;

import java.net.InetSocketAddress;

/**
 * @author sksingh created on 25/11/23
 */
public class ServerConfiguration {

    private static ServerConfiguration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfiguration(int port, String greetingMessage) {
        System.out.println("Creating Server Configuration");
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if (serverConfigurationInstance == null) {
            serverConfigurationInstance = this;
        }
    }

    public static ServerConfiguration getInstance() {
        return serverConfigurationInstance;
    }

    public InetSocketAddress getServerAddress() {
        return this.serverAddress;
    }

    public String getGreetingMessage() {
        return this.greetingMessage;
    }

}
