package com.example.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myblog.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * Week06：只声明"我要对 message 表做 CRUD"，SQL 交给 MyBatis-Plus 生成。
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
