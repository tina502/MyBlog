package com.example.myblog.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myblog.common.PageResult;
import com.example.myblog.entity.Message;
import com.example.myblog.mapper.MessageMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Week06 的实现：同一个 MessageRepository 接口，换成 MySQL 落盘。
 * Service 完全不知道这里换了实现——这就是 Week05 抽接口的回报。
 */
@Repository
public class DbMessageRepository implements MessageRepository {

    private final MessageMapper messageMapper;

    public DbMessageRepository(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public Message save(Message message) {
        // insert 之后 MyBatis-Plus 会把自增主键回填到 message.id
        messageMapper.insert(message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        return messageMapper.selectList(
                new LambdaQueryWrapper<Message>().orderByAsc(Message::getId));
    }

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.ofNullable(messageMapper.selectById(id));
    }

    @Override
    public PageResult<Message> page(String keyword, long page, long size) {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<Message>()
                .like(keyword != null && !keyword.isBlank(), Message::getContent, keyword)
                .orderByAsc(Message::getId);
        Page<Message> result = messageMapper.selectPage(new Page<>(page, size), wrapper);
        return new PageResult<>(result.getRecords(), result.getTotal(), page, size);
    }
}
