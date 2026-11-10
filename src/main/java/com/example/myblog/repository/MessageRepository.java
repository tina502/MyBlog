package com.example.myblog.repository;

import com.example.myblog.common.PageResult;
import com.example.myblog.entity.Message;

import java.util.List;
import java.util.Optional;

/**
 * Week05：存储的"抽象"。Service 只认这个接口，不关心数据放在 List 还是 MySQL。
 * Week06 换成 MySQL 时，这个接口一个字都没改。
 */
public interface MessageRepository {

    Message save(Message message);

    List<Message> findAll();

    Optional<Message> findById(Long id);

    /** Week07：按关键词过滤 + 分页切片，实现方自己决定怎么"切" */
    PageResult<Message> page(String keyword, long page, long size);
}
