package com.shivam.learn;

public class ServiceTrace {

    private String serviceName;
    private String request;
    private String response;

    public ServiceTrace(String serviceName, String request, String response) {
        this.serviceName = serviceName;
        this.request = request;
        this.response = response;
    }

    @Override
    public String toString() {
        return "ServiceTrace{" + "serviceName='" + serviceName + '\'' + ", request='" + request + '\'' + ", response='" + response + '\'' + '}';
    }
}
