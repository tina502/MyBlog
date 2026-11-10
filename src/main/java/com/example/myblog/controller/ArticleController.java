package com.example.myblog.controller;

import com.example.myblog.common.ApiResponse;
import com.example.myblog.entity.Article;
import com.example.myblog.service.ArticleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Week08：Article 的完整生命周期，全部走统一契约 {code, message, data}。
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /** 发布：返回自增 id */
    @PostMapping
    public ApiResponse<Article> publish(@RequestBody Map<String, String> body) {
        return ApiResponse.ok(articleService.publish(body.get("title"), body.get("content")));
    }

    @GetMapping
    public ApiResponse<List<Article>> list() {
        return ApiResponse.ok(articleService.list());
    }

    /** 单篇：不存在时由 GlobalExceptionHandler 翻成 404 JSON */
    @GetMapping("/{id}")
    public ApiResponse<Article> get(@PathVariable Long id) {
        return ApiResponse.ok(articleService.get(id));
    }

    /** 修订：改完立刻回读得到新内容 */
    @PutMapping("/{id}")
    public ApiResponse<Article> revise(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return ApiResponse.ok(articleService.revise(id, body.get("title"), body.get("content")));
    }

    /** 删除：同 id 再 GET 必须 404 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable Long id) {
        articleService.remove(id);
        return ApiResponse.ok(null);
    }
}
