package cn.junhui.service;

import cn.junhui.pojo.User;

/**
 * Name: UserService
 * Package: cn.junhui.service
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 13:19
 * @Version: v1.0
 */

public interface UserService {

    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册
    void register(String username, String password);

    // 更新
    void update(User user);

    // 更新头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
