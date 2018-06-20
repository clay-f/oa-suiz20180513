package com.f.helper;

import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RedisUtil {
    @Autowired
    private RedissonClient  redissonClient;

    public RedissonClient getRedissonClient() {
        Config config = redissonClient.getConfig();
        return redissonClient;
    }
}
