package cn.junhui;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Name: JwtTest
 * Package: cn.junhui
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 16:39
 * @Version: v1.0
 */

public class JwtTest {

    @Test
    public void testGen() {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        // 生成jwt的代码
        String token = JWT.create()
                .withClaim("user",claims) // 添加载荷
                // 添加过期时间,System.currentTimeMillis()系统当前毫秒值
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
                .sign(Algorithm.HMAC256("junhui")); // 指定算法，配置密钥
        System.out.println(token);
    }

    @Test
    public void testParse() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                         ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MDU4NzAxNTB9" +
                         ".dAEpJwhcxq3vE5TY3dNnx70UtoHaLSEDj1pK4ggNFz4";
        // 申请JWT验证器
        // （算法）:Algorithm.HMAC256;.build()生成验证器
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("junhui")).build();
        // 验证token，生成一个解析后的JWT对象
        DecodedJWT decodeJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodeJWT.getClaims();
        System.out.println(claims.get("user"));

        /*
        验证失败的情况:
          1.如果篡改了头部和载荷部分的数据，那么验证失败
          2.如果密钥改了，验证失败
          3.token过期
         */
    }
}