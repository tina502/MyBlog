-- ============================================================
-- Week06：建库建表（utf8mb4，中文留言不乱码）
-- 执行：mysql -uroot -p < sql/schema.sql
-- ============================================================
CREATE DATABASE IF NOT EXISTS myblog
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE myblog;

-- 留言表：id 自增由数据库负责，Java 侧不自己造 id
CREATE TABLE IF NOT EXISTS message (
    id      BIGINT       NOT NULL AUTO_INCREMENT COMMENT '留言自增主键',
    content VARCHAR(500) NOT NULL COMMENT '留言正文',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '博客留言';

-- ============================================================
-- Week08：文章表（发布 / 单篇 / 修订 / 删除）
-- ============================================================
CREATE TABLE IF NOT EXISTS article (
    id      BIGINT       NOT NULL AUTO_INCREMENT COMMENT '文章自增主键',
    title   VARCHAR(200) NOT NULL COMMENT '标题',
    content TEXT COMMENT '正文',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '博客文章';
