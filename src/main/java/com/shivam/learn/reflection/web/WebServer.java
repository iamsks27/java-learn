package com.shivam.learn.reflection.web;

import com.shivam.learn.reflection.ServerConfiguration;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author sksingh created on 25/11/23
 */
public class WebServer {

    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(ServerConfiguration.getInstance().getServerAddress(), 0);

        httpServer.createContext("/greeting")
                .setHandler(exchange -> {
                    String responseMsg = ServerConfiguration.getInstance().getGreetingMessage();

                    exchange.sendResponseHeaders(200, responseMsg.length());
                    OutputStream responseBody = exchange.getResponseBody();
                    responseBody.write(responseMsg.getBytes());
                    responseBody.flush();
                    responseBody.close();
                });


        System.out.printf("Starting server on address %s: %d\n",
                ServerConfiguration.getInstance().getServerAddress().getHostName(),
                ServerConfiguration.getInstance().getServerAddress().getPort()
        );

        httpServer.start();
    }

}
