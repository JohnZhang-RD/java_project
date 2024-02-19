package cn.junhui.service;

import cn.junhui.pojo.Article;
import cn.junhui.pojo.PageBean;

/**
 * Name: ArticleService
 * Package: cn.junhui.service
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/25 - 17:22
 * @Version: v1.0
 */

public interface ArticleService {
    // 新增文章
    void add(Article article);

    // 文章列表（条件分页）
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
