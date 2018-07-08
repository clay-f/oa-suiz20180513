package com.f.core.schedule;

import com.f.core.common.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RMapCheSchedule implements Job {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        RMapCache<String, Object> rMapCache = redissonClient.getMapCache(Constants.RMAP_CACHE_NAME);
        rMapCache.clear();
    }
}
