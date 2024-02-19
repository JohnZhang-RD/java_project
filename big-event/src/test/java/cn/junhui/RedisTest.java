package cn.junhui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * Name: RedisTest
 * Package: cn.junhui
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/27 - 19:40
 * @Version: v1.0
 */

@SpringBootTest // 单元测试方法执行之前，会先初始化Spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet() {
        // 往redis中 存储一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("username", "zhangsan");
        operations.set("id", "1", 15, TimeUnit.SECONDS);
    }

    @Test
    public void testGet() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        System.out.println(operations.get("name"));
        System.out.println(operations.get("id"));
    }
}
