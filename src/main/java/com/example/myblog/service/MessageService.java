package com.example.myblog.service;

import com.example.myblog.common.PageResult;
import com.example.myblog.entity.Message;

import java.util.List;

/**
 * Week05：Controller 只认这个接口。
 * 删掉实现类上的 @Service，启动就会报 required a bean of type 'MessageService'。
 */
public interface MessageService {

    /** 发布一条留言，返回带自增 id 的那条 */
    Message publish(String content);

    /** 全部留言（Week04 的老行为，必须保持不变） */
    List<Message> list();

    /** 按 id 取一条，取不到抛 NoSuchElementException，由统一异常处理器翻成 404 */
    Message get(Long id);

    /** Week07：keyword 检索 + 分页，一次查询只回一页 */
    PageResult<Message> search(String keyword, long page, long size);
}
