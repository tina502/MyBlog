package com.example.myblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalController {

    @GetMapping("/profile")
    public PersonalProfile getProfile() {
        PersonalProfile profile = new PersonalProfile(
                "TechNote博客",
                "小明",
                "一个记录后端学习、编程实验的个人博客",
                "Java、SpringBoot、离散数学、计算机网络",
                "持续学习，把技术变成解决问题的工具"
        );
        return profile;
    }

    @GetMapping("/me")
    public PersonalProfile getMe() {
        PersonalProfile me = new PersonalProfile(
                "我的博客",
                "你的名字",
                "这是我的个人主页",
                "编程、健身、看书",
                "不断进步"
        );
        return me;
    }
}





