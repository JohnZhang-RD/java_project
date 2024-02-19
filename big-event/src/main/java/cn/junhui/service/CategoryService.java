package cn.junhui.service;

import cn.junhui.pojo.Category;

import java.util.List;

/**
 * Name: CategoryService
 * Package: cn.junhui.service
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/25 - 13:43
 * @Version: v1.0
 */

public interface CategoryService {
    // 增加文章分类
    void add(Category category);

    // 列表查询
    List<Category> list();

    // 根据id查询分类信息
    Category findById(Integer id);

    // 更新分类
    void update(Category category);

    // 根据id删除分类信息
    void delete(Integer id);
}
