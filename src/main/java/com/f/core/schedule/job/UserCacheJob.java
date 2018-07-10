package com.f.core.schedule.job;

import com.f.core.common.Constants;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCacheJob implements Job {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        RMapCache<String, Object> rMapCache = redissonClient.getMapCache(Constants.USER_CACHE_NAME);
        rMapCache.clear();
    }
}
