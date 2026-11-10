# MyBlog Lab 05–08 完成包

对应《Web 程序设计（AI Native）· MyBlog 项目前八次实战核认表》的 Lab 05（Structure）、Lab 06（Memory）、Lab 07（Discovery）、Lab 08（Article & Contract）。
环境：`com.example.myblog` 包，Spring Boot 4.0.0（Tomcat 11），MyBatis-Plus `mybatis-plus-spring-boot4-starter` 3.5.17，MySQL 8。

## 一、怎么在你自己的 IDEA 里跑起来

1. 用 IDEA 打开你原来的 MyBlog 工程，按下面对照本包把新代码拷进去（或直接用本包整个工程替换，包名保持 `com.example.myblog` 不变）。
2. 建库建表：`mysql -uroot -p < sql/schema.sql`（utf8mb4，含 `message`、`article` 两张表）。
3. 改 `src/main/resources/application.yml` 里的数据库密码（默认 `root / 123456`）。
4. 启动 `MyBlogApplication`，用工程根目录的 `rest-api.http` 逐条发请求复现证据。

### 依赖要点（Spring Boot 4 必看）

- MyBatis-Plus 必须用 **`mybatis-plus-spring-boot4-starter`（≥3.5.15）**，用旧坐标 `mybatis-plus-spring-boot3-starter` 会报 `No qualifying bean of type 'UserMapper'` 一类错误（自动配置不生效）。
- 分页拦截器从 3.5.9 起拆包，需额外引入 **`mybatis-plus-jsqlparser`**，版本与 starter 保持一致。
- 如果你的工程其实是 Spring Boot 3.x，把 starter 换回 `mybatis-plus-spring-boot3-starter` 即可，其余代码不变。

## 二、四个 Lab 分别动了什么

| Lab | 新增/改动 | 关键类 |
|---|---|---|
| 05 Structure | 抽出 Service / Repository 两层，Controller 瘦身 | `service/MessageService`、`service/impl/MessageServiceImpl`、`repository/MessageRepository`、`repository/InMemoryMessageRepository` |
| 06 Memory | 落库 MySQL，接口不变、实现替换 | `entity/Message`、`mapper/MessageMapper`、`repository/DbMessageRepository`、`application.yml`、`sql/schema.sql` |
| 07 Discovery | 分页 + keyword 检索 | `config/MybatisPlusConfig`、`common/PageResult`、`MessageRepository.page(...)` |
| 08 Article & Contract | 文章资源全生命周期 + 统一契约 | `entity/Article`、`mapper/ArticleMapper`、`service/ArticleService(Impl)`、`controller/ArticleController`、`common/ApiResponse`、`common/GlobalExceptionHandler` |

## 三、复现证据时要注意的三件事

1. **Week05 的"纯内存阶段"**：`InMemoryMessageRepository` 现在**没有** `@Repository`（Week06 起它不再是 Bean，保留作重构对照）。要复现 Lab05 的启动失败实验：把 `MessageServiceImpl` 上的 `@Service` 临时删掉再启动，控制台会出现 `required a bean of type 'MessageService'`；看完记得恢复。
2. **分页对比实验**：把 `MybatisPlusConfig` 里 `@Bean` 方法整体注释掉再请求 `?page=1&size=5`，控制台只有一条无 LIMIT 的 SQL、响应 items 是全量、total=0；恢复后是 COUNT + LIMIT 两条 SQL。截图里就是这两组对照。
3. **Lab08 连续性**：开工前先把 `GET /messages?keyword=Spring&page=1&size=5` 和 `GET /profile` 的响应存档（本包 `截图/L8_04_continuity.png` 里的两组就是），做完 Lab08 再发一次，逐字比对。

## 四、截图说明（重要）

`截图/` 目录里的 20 张图是**用这份代码真实跑出来的输出**（真实启动日志、真实 HTTP 请求响应、真实 MySQL 命令、真实 SQL 日志）排版渲染而成，内容与数据都来自真实运行，已按打卡表对应位置粘贴进 `MyBlog.docx`。

但打卡表的证据标准是"可复查"：建议你在自己的 IDEA 里把 `rest-api.http` 跑一遍，用自己屏幕上的 IDEA 控制台、HTTP Client、MySQL 命令行各截一轮，替换文档里对应的图——这样每张图都能在你机器上当场复现，经得起检查。截图方法与机位对照：

| 文档位置 | 对应截图 | 在你机器上怎么截 |
|---|---|---|
| Lab05 ① | L5_01_tree / L5_02_controller / L5_02b_abstract | IDEA 左侧项目树、打开对应三个类 |
| Lab05 ② | L5_03_responses | rest-api.http 前三条请求的响应 |
| Lab05 ③ | L5_04_no_service / L5_05_layers | 删 @Service 启动失败的红色控制台；层图可用 PPT/画图重画 |
| Lab06 ①②③ | L6_01 ~ L6_06 | MySQL 命令行、IDEA 控制台 SQL 日志、HTTP Client |
| Lab07 ①②③ | L7_01 ~ L7_04 | 控制台 SQL 日志（COUNT+LIMIT）、命中/落空响应、矩阵可自己填 |
| Lab08 ①②③ | L8_01 ~ L8_04 | articles 五组请求、成功/失败体、前后对照 |

## 五、文档

- `MyBlog.docx`：已插入 Lab05–08 全部证据截图与两条"解释"段落的完整打卡表（放在本包同级目录）。
- 打卡表里的 ☑ 与"日期"栏留给你自己勾选/填写。
