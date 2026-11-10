package com.example.myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.myblog.entity.Article;
import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Week08：Article 的业务层。
 * 找不到资源时抛 NoSuchElementException —— 这是"业务说人话"，翻成 HTTP 404 是外层的事。
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public Article publish(String title, String content) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title 不能为空");
        }
        Article article = new Article(null, title, content);
        articleMapper.insert(article);
        return article;
    }

    @Override
    public Article get(Long id) {
        Article article = articleMapper.selectById(id);
        if (article == null) {
            throw new NoSuchElementException("文章不存在：id=" + id);
        }
        return article;
    }

    @Override
    public Article revise(Long id, String title, String content) {
        Article article = get(id);
        if (title != null && !title.isBlank()) {
            article.setTitle(title);
        }
        if (content != null) {
            article.setContent(content);
        }
        articleMapper.updateById(article);
        return article;
    }

    @Override
    public void remove(Long id) {
        get(id);
        articleMapper.deleteById(id);
    }

    @Override
    public List<Article> list() {
        return articleMapper.selectList(new LambdaQueryWrapper<Article>().orderByAsc(Article::getId));
    }
}
