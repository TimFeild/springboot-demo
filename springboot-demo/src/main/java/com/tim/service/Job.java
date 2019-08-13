package com.tim.service;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class Job {
    @Autowired
    private Jedis jedis;

    @Scheduled(cron = "0/10 * * * * ? ")
    @SchedulerLock(name = "demoJob", lockAtMostFor = 10000, lockAtLeastFor = 10000)
    public void execute() {
        try {
            System.out.println(jedis.get("firstKey"));
            String str = jedis.get("job-lock");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
