package com.f.core.config;

import com.f.core.schedule.RMapCheSchedule;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@EnableScheduling
@Component
public class QuartzConfig implements InitializingBean {
    private Scheduler scheduler = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail jobDetail = newJob(RMapCheSchedule.class)
                .withIdentity("cleanRedissonCache", "redissionCache").build();

        Trigger trigger = newTrigger()
                .withIdentity("triggerCleanRedissonCache", "cleanRedissonCache")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(120)).build();
        JobDetail dogJob = newJob(DogSay.class)
                .withIdentity("dogSay", "dog").build();
        Trigger dogsay = newTrigger()
                .withIdentity("dogsay", "dogsay")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(10)).build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.scheduleJob(dogJob, dogsay);
    }

    @PreDestroy
    public void destroy() throws SchedulerException {
        scheduler.shutdown();
    }

}
