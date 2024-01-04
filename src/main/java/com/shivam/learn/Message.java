package com.shivam.learn;

public class Message {

    private String display;
    private String description;

    public Message(String display, String description) {
        this.display = display;
        this.description = description;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Message{" + "display='" + display + '\'' + ", description='" + description + '\'' + '}';
    }
}