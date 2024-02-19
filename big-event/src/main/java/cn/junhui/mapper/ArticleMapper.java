package cn.junhui.mapper;

import cn.junhui.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Name: ArticleMapper
 * Package: cn.junhui.mapper
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/25 - 17:23
 * @Version: v1.0
 */

@Mapper
public interface ArticleMapper {

    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
                    "VALUES(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    // 动态sql
    List<Article> list(Integer userId, Integer categoryId, String state);
}
