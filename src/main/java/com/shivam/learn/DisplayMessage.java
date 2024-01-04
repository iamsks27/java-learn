package com.shivam.learn;

public class DisplayMessage {

    private String id;
    private String module;
    private String page;
    private String section;
    private String type;
    private String lang;
    private Message message;

    public DisplayMessage(String id, String module, String page, String section, String type, String lang,
            Message message) {
        this.id = id;
        this.module = module;
        this.page = page;
        this.section = section;
        this.type = type;
        this.lang = lang;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DisplayMessage{" + "id='" + id + '\'' + ", module='" + module + '\'' + ", page='" + page + '\'' + ", section='" + section + '\'' + ", type='" + type + '\'' + ", lang='" + lang + '\'' + ", message=" + message + '}';
    }
}