package com.example.myblog.service;

import com.example.myblog.entity.Article;

import java.util.List;

public interface ArticleService {

    Article publish(String title, String content);

    Article get(Long id);

    Article revise(Long id, String title, String content);

    void remove(Long id);

    List<Article> list();
}
