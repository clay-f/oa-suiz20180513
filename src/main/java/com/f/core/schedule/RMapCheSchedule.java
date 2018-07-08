package com.f.core.schedule;

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
        RMapCache<String, Object> rMapCache = redissonClient.getMapCache("rMapCache");
        logger.debug("rmapcache clean schedule start...");
        System.out.println("rmapcache clean schedule start...");
        rMapCache.clear();
    }
}
