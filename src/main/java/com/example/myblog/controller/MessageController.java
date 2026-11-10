package com.example.myblog.controller;

import com.example.myblog.entity.Message;
import com.example.myblog.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Week05 之后的 Controller：只做三件事——收请求、调 Service、还响应。
 * 类里没有任何 List、没有 id 自增逻辑、没有 try-catch。
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /** Week04 老接口：POST 一条留言，响应里原样带回（含数据库回填的 id） */
    @PostMapping
    public Message publish(@RequestBody Map<String, String> body) {
        return messageService.publish(body.get("content"));
    }

    /**
     * 不带分页参数 → 保持 Week04 的老行为，返回数组；
     * 带 keyword / page / size → Week07 的分页检索，返回 {items,total,page,size}。
     */
    @GetMapping
    public Object list(@RequestParam(required = false) String keyword,
                       @RequestParam(required = false) Long page,
                       @RequestParam(required = false) Long size) {
        if (keyword == null && page == null && size == null) {
            return messageService.list();
        }
        return messageService.search(keyword, page == null ? 1 : page, size == null ? 5 : size);
    }

    /** Week04 老接口：取一条 */
    @GetMapping("/{id}")
    public Message get(@PathVariable Long id) {
        return messageService.get(id);
    }
}
