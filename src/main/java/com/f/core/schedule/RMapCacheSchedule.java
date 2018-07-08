package com.f.core.schedule;

import com.f.core.schedule.job.RMapCheScheduleJob;
import org.quartz.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

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

        Trigger trigger = newTrigger()
                .withIdentity("cleanCacheTrigger", "group2")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
        sched.scheduleJob(jobDetail, trigger);
    }

    @PreDestroy
    public void destroy() throws SchedulerException {
        sched.shutdown();
    }
}
