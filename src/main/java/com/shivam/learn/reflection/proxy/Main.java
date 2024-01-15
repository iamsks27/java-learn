package com.shivam.learn.reflection.proxy;


import com.shivam.learn.reflection.proxy.external.DatabaseReader;
import com.shivam.learn.reflection.proxy.external.HttpClient;
import com.shivam.learn.reflection.proxy.external.impl.HttpClientImpl;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sksingh created on 15/01/24
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = createProxy(new HttpClientImpl());
        useHttpClient(httpClient);

        // DatabaseReader databaseReader = new DatabaseReaderImpl();
        // useDatabaseReader(databaseReader);
    }

    private static void useHttpClient(HttpClient httpClient) {
        httpClient.initialise();
        String response = httpClient.sendRequest("some request");

        System.out.printf("Http response is: %s%n", response);
    }


    private static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException, IOException {
        int rowsInGamesTable = databaseReader.countRowsInTable("GamesTable");
        System.out.printf("There are %s rows in GamesTable%n", rowsInGamesTable);

        String[] data = databaseReader.readRows("SELECT * FROM GamesTable");
        System.out.printf("Received %s%n", String.join(", ", data));
    }

    @SuppressWarnings("unchecked")
    private static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();

        return (T) Proxy.newProxyInstance(
                originalObject.getClass().getClassLoader(),
                interfaces,
                new TimeMeasuringProxyHandler(originalObject)
        );
    }

    private record TimeMeasuringProxyHandler(Object originalObject) implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;

            System.out.printf("Measuring Proxy - Before Executing method: %s()%n", method.getName());

            long startTime = System.nanoTime();

            try {
                result = method.invoke(originalObject, args);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }

            long endTime = System.nanoTime();
            System.out.printf(
                    "Measuring proxy - Execution of %s() took %dns%n",
                    method.getName(),
                    (endTime - startTime)
            );

            return result;
        }
    }
}
