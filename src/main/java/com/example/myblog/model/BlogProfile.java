package com.example.myblog.model;

/**
 * Week02 的 /me 响应对象：由 String 升级成 JSON 对象的产物。
 */
public class BlogProfile {

    private String name;
    private String owner;
    private String message;

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
