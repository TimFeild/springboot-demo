package com.tim.config;


import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.provider.redis.jedis.JedisLockProvider;
import org.rocksdb.Env;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

import javax.sql.DataSource;

@Configuration
public class ShedlockConfig {
    @Bean
    public LockProvider lockProvider(JedisPool jedisPool) {
        return new JedisLockProvider(jedisPool);
    }
//    @Bean
//    public LockProvider lockProvider(DataSource primaryDataSource){
//        return new JdbcTemplateLockProvider(primaryDataSource);
//    }


}

