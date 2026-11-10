package com.example.myblog.controller;

import com.example.myblog.model.BlogProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    /** Week01：第一句能被浏览器看到的话 */
    @GetMapping("/hello")
    public String hello() {
        return "你好，我是杨雅婷，这是我的第一个 Spring Boot 接口";
    }

    /** Week02：String 升级成 JSON 对象 */
    @GetMapping("/me")
    public BlogProfile me() {
        return new BlogProfile("我的博客", "杨雅婷", "把每周学到的都写进这个博客里");
    }
}
