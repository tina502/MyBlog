package com.example.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
