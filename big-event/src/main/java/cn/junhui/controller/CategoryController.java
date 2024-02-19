package cn.junhui.controller;

import cn.junhui.pojo.Category;
import cn.junhui.pojo.Result;
import cn.junhui.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Name: CategoryController
 * Package: cn.junhui.controller
 * Description: 文章分类
 *
 * @author Junhui Zhang
 * @Date: 2024/01/24 - 21:45
 * @Version: v1.0
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> data = categoryService.list();
        return Result.success(data);
    }

    @GetMapping("/detail")
    public Result<Category> detail(Integer id) {
        Category c = categoryService.findById(id);
        return Result.success(c);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id) {
        categoryService.delete(id);
        return Result.success();
    }
}
