package com.shivam.learn;

import java.util.HashMap;
import java.util.Map;

public class ServiceTraceContext {
    private Map<String, ServiceTrace> traces = new HashMap<>();

    public void add(String serviceName, ServiceTrace trace) {
        traces.put(serviceName, trace);
    }

    public Map<String, ServiceTrace> getTraces() {
        return traces;
    }

    @Override
    public String toString() {
        return "ServiceTraceContext{" + "traces=" + traces + '}';
    }
}
