package com.example.myblog.service.impl;

import com.example.myblog.common.PageResult;
import com.example.myblog.entity.Message;
import com.example.myblog.repository.MessageRepository;
import com.example.myblog.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Week05：业务层。类里没有 List、没有 Mapper，只有"存储抽象"。
 * Week06：数据落到 MySQL，本类一行没改。
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    // 构造器注入：Spring 启动时必须找到一个 MessageRepository Bean 才能造出本类
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message publish(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content 不能为空");
        }
        return messageRepository.save(new Message(null, content));
    }

    @Override
    public List<Message> list() {
        return messageRepository.findAll();
    }

    @Override
    public Message get(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("留言不存在：id=" + id));
    }

    @Override
    public PageResult<Message> search(String keyword, long page, long size) {
        long safePage = page < 1 ? 1 : page;
        long safeSize = size < 1 ? 5 : size;
        return messageRepository.page(keyword, safePage, safeSize);
    }
}
