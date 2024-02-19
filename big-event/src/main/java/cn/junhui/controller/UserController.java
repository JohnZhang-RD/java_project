package cn.junhui.controller;

import cn.junhui.pojo.Result;
import cn.junhui.pojo.User;
import cn.junhui.service.UserService;
import cn.junhui.utils.JwtUtil;
import cn.junhui.utils.Md5Util;
import cn.junhui.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Name: UserController
 * Package: cn.junhui.controller
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 13:19
 * @Version: v1.0
 */

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password) {
        // 查询用户
        User u = userService.findByUserName(username);
        if (u==null) {
            // 注册
            userService.register(username, password);
            return Result.success();
        } else {
            // 该用户名被占用
            return Result.error("用户名已被占用");
        }
    }

    // 返回类型是String类型的token
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        // 判断用户是否存在
        if (loginUser==null) {
            return Result.error("用户名错误");
        }
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登录成功
            // 获取token
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);

            // 把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 12, TimeUnit.HOURS);

            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/) {
        /*
            // 根据用户名查询用户
            Map<String, Object> map = JwtUtil.parseToken(token);
            String username= (String)map.get("username");
            User user = userService.findByUserName(username);
        */
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String)map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params, @RequestHeader("Authorization") String toekn) {
        // 1.校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少必要的参数");
        }

        // 原密码是否正确
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密码不正确");
        }

        // 比对新密码和第二次输入的密码是否相同
        if (!rePwd.equals(newPwd)) {
            return Result.error("两次输入密码不相同");
        }

        // 2.调用service完成密码更新
        userService.updatePwd(newPwd);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(toekn);
        return Result.success();
    }
}
