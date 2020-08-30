package redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.RedisUtils.RedisUtil;

@SpringBootTest
public class RedisTest {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        redisUtil.set("university", "Southwest University of Science and Technology");
        System.out.println(redisUtil.get("university"));
    }

}
