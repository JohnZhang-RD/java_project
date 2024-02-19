package cn.junhui.mapper;

import cn.junhui.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Name: UserMapper
 * Package: cn.junhui.mapper
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 13:19
 * @Version: v1.0
 */

@Mapper
public interface UserMapper {

    // 根据用户名查询数据
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user(username,password,create_time,update_time)" +
                    "values(#{username},#{password},now(),now())")
    void add(String username, String password);

    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Update("update user set user_pic=#{avatarUrl}, update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user set password=#{password}, update_time=now() where id=#{id}")
    void updatePwd(String password, Integer id);
}