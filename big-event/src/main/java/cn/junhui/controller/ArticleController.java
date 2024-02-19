package cn.junhui.controller;

import cn.junhui.pojo.Article;
import cn.junhui.pojo.PageBean;
import cn.junhui.pojo.Result;
import cn.junhui.service.ArticleService;
import cn.junhui.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Name: ArticleController
 * Package: cn.junhui.controller
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 18:31
 * @Version: v1.0
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }
}
