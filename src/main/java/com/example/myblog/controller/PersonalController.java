package com.example.myblog.controller;

import com.example.myblog.model.PersonalProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalController {

    /** Week03：5 个有真实含义的字段，只读 JSON 就能判断这是谁的博客 */
    @GetMapping("/profile")
    public PersonalProfile getProfile() {
        PersonalProfile profile = new PersonalProfile(
                "TechNote博客",
                "小婷",
                "一个记录计算机编程学习的个人博客",
                "Java、C++、C语言",
                "把技术变成解决问题的工具"
        );
        return profile;
    }
}
