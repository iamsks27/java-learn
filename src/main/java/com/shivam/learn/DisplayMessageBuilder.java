package com.shivam.learn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayMessageBuilder {

    private static final Map<String, DisplayMessage> messages;

    static {
        messages = new HashMap<>();
        init();
    }

    private static void init() {
        InputStream inputStream = null;
        Reader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("/Users/shivamsingh/Documents/code/java/src/main/resources/display_message.json"));
            final Type type = new TypeToken<List<DisplayMessage>>() {
            }.getType();
            final List<DisplayMessage> displayMessages = new Gson().fromJson(reader, type);
            for (final DisplayMessage displayMessage : displayMessages) {
                messages.put(displayMessage.getId(), displayMessage);
            }
        } catch (Exception e) {
            System.out.println("Failed to construct init map of key features from the file");
        } finally {
            //cleanup(inputStream, reader);
        }
    }

    public static void main(String[] args) {
        System.out.println(messages);
    }
}
