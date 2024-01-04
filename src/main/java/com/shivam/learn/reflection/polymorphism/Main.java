package com.shivam.learn.reflection.polymorphism;

import com.shivam.learn.reflection.polymorphism.database.DatabaseClient;
import com.shivam.learn.reflection.polymorphism.http.HttpClient;
import com.shivam.learn.reflection.polymorphism.logging.FileLogger;
import com.shivam.learn.reflection.polymorphism.udp.UdpClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sksingh created on 04/01/24
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        DatabaseClient databaseClient = new DatabaseClient();
        HttpClient httpClient1 = new HttpClient("123.456.789.0");
        HttpClient httpClient2 = new HttpClient("11.33.55.0");
        FileLogger fileLogger = new FileLogger();
        UdpClient udpClient = new UdpClient();

        String requestBody = "request payload";

        List<Class<?>> methodParameterType = Arrays.asList(new Class<?>[]{String.class});

        Map<Object, Method> requestExecutors = groupExecutors(
                Arrays.asList(databaseClient, httpClient1, httpClient2, fileLogger, udpClient), methodParameterType);

        executeAll(requestExecutors, requestBody);
    }

    private static void executeAll(Map<Object, Method> requestExecutors, String data) throws InvocationTargetException, IllegalAccessException {
        for (Map.Entry<Object, Method> entry : requestExecutors.entrySet()) {
            Object k = entry.getKey();
            Method v = entry.getValue();
            v.invoke(k, data);
        }
    }

    private static Map<Object, Method> groupExecutors(
            List<Object> requestExecutors, List<Class<?>> methodParameterTypes
    ) {
        Map<Object, Method> instanceToMethod = new HashMap<>();

        for (Object requestExecutor : requestExecutors) {
            Method[] allMethods = requestExecutor.getClass().getDeclaredMethods();

            for (Method method : allMethods) {
                if (Arrays.asList(method.getParameterTypes()).equals(methodParameterTypes)) {
                    instanceToMethod.put(requestExecutor, method);
                }
            }
        }

        return instanceToMethod;
    }
}
