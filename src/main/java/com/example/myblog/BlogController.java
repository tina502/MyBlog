package com.example.myblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @GetMapping("/me")
    public BlogProfile me(){
        return new BlogProfile ("我的博客","杨雅婷", "welcome to my blog");
    }
}

