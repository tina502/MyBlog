package com.example.myblog;

public class BlogProfile {
    private String blogName;
    private String owner;
    private String message;

    //构造方法
    public BlogProfile(String blogName, String owner, String message) {
        this.blogName = blogName;
        this.owner = owner;
        this.message = message;
    }

    public String getBlogName() {
        return blogName;
    }
    public String getOwner() {
        return owner;
    }
    public String getMessage() {
        return message;
    }
}
