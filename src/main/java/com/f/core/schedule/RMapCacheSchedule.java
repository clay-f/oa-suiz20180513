package com.f.core.schedule;

import com.f.core.schedule.job.RMapCheScheduleJob;
import com.f.core.schedule.job.UserCacheJob;
import org.quartz.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;

@Component
public class RMapCacheSchedule implements InitializingBean {
    private Scheduler sched = null;
    @Override
    public void afterPropertiesSet() throws Exception {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        sched = schedFact.getScheduler();
        sched.start();
        JobDetail jobDetail = newJob(RMapCheScheduleJob.class)
                .withIdentity("cleanCacheJob", "group1")
                .build();

        JobDetail clearUserCache = newJob(UserCacheJob.class)
                .withIdentity("cleanUserCache", "group1")
                .build();

        CronTrigger userCacheTrigger = newTrigger()
                .withIdentity("cleanUserCacheTrigger", "group1")
                .withSchedule(dailyAtHourAndMinute(0, 0))
                .forJob(clearUserCache).build();

        Trigger trigger = newTrigger()
                .withIdentity("cleanCacheTrigger", "group2")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(60).repeatForever())
                .build();
        sched.scheduleJob(jobDetail, trigger);
        sched.scheduleJob(clearUserCache, userCacheTrigger);
    }

    @PreDestroy
    public void destroy() throws SchedulerException {
        sched.shutdown();
    }
}
