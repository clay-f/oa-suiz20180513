package com.f.test;

import com.f.helper.RedisHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RedisTest {
    @Autowired
    private RedissonClient redissonClient;
    @Test
    void say() {
        try {
            redissonClient.getConfig().toJSON().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RBucket<String> bucket = RedisHelper.getRBucket(redissonClient, "test");
        bucket.set("test");
        System.out.println(bucket.get());
    }

}
