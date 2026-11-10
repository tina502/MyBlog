package com.example.myblog.repository;

import com.example.myblog.common.PageResult;
import com.example.myblog.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Week05（Structure 阶段）的实现：数据活在 JVM 堆内存里，进程一停就没了。
 * Week06 起真实数据写进 MySQL，本类保留作"重构前后对照"用，不再被装配成 Bean（没有 @Repository）。
 */
public class InMemoryMessageRepository implements MessageRepository {

    private final List<Message> messages = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Message save(Message message) {
        message.setId(idGenerator.getAndIncrement());
        messages.add(message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(messages);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messages.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst();
    }

    @Override
    public PageResult<Message> page(String keyword, long page, long size) {
        List<Message> matched = new ArrayList<>();
        for (Message message : messages) {
            if (keyword == null || keyword.isBlank() || message.getContent().contains(keyword)) {
                matched.add(message);
            }
        }
        int from = (int) Math.min((page - 1) * size, matched.size());
        int to = (int) Math.min(from + size, matched.size());
        return new PageResult<>(matched.subList(from, to), matched.size(), page, size);
    }
}
