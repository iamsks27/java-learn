package com.shivam.learn.reflection;

import com.shivam.learn.reflection.web.WebServer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author sksingh created on 25/11/23
 */
public class ServerConfigurationTest {

    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        initConfiguration();

        WebServer webServer = new WebServer();
        webServer.startServer();
    }

    public static void initConfiguration()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<ServerConfiguration> constructor =
                ServerConfiguration.class.getDeclaredConstructor(int.class, String.class);

        constructor.setAccessible(true);
        constructor.newInstance(8080, "Hello, World!");
    }

}
