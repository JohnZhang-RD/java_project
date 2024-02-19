package cn.junhui.service.impl;

import cn.junhui.mapper.ArticleMapper;
import cn.junhui.pojo.Article;
import cn.junhui.pojo.PageBean;
import cn.junhui.service.ArticleService;
import cn.junhui.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Name: ArticleServiceImpl
 * Package: cn.junhui.service.impl
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/25 - 17:22
 * @Version: v1.0
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 1.创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
        // 2.开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        // 3.调用Mapper层
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as = articleMapper.list(userId, categoryId, state);
        // Page中提供了方法，可以获取PageHelper分页查询后，得到的总记录条数和当页数据
        Page<Article> p = (Page<Article>) as;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
