package com.example.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Week06：Message 从"内存里的一个对象"变成"message 表的一行"。
 */
@TableName("message")
public class Message {

    /** 主键由数据库自增回填，Java 侧不自己造 id */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String content;

    public Message() {
    }

    public Message(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
