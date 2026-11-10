package com.example.myblog.model;

/**
 * Week03 的身份对象：5 个字段都能回答"这是谁的博客"。
 */
public class PersonalProfile {

    private String blogName;
    private String owner;
    private String introduction;
    private String interests;
    private String vision;

    public PersonalProfile(String blogName, String owner, String introduction, String interests, String vision) {
        this.blogName = blogName;
        this.owner = owner;
        this.introduction = introduction;
        this.interests = interests;
        this.vision = vision;
    }

    public String getBlogName() {
        return blogName;
    }

    public String getOwner() {
        return owner;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getInterests() {
        return interests;
    }

    public String getVision() {
        return vision;
    }
}
