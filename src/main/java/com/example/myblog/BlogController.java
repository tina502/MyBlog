package com.example.myblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @GetMapping("/hello")
    public String hello() {
        return "你好，我是杨雅婷";
    }

    @GetMapping("/me")
    public String me() {
        return "我是杨雅婷，喜欢唱歌跳舞，你呢";
    }

}