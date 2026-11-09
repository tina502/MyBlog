package com.example.myblog;

public class BlogProfile {
    private String name;
    private String owner;
    private String message;

    //构造方法
    public BlogProfile(String name, String owner, String message) {
        this.name = name;
        this.owner = owner;
        this.message = message;
    }

    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }
    public String getMessage() {
        return message;
    }
}
