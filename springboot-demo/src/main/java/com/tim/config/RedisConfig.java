package com.tim.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@ConfigurationProperties(prefix = "redis")
@Component
@Getter
@Setter
public class RedisConfig {
    private String ip;
    private Integer port;
    private String pass;
    private Integer maxTotal;
    private Integer maxIdle;

    @Bean("jedisPool")
    public JedisPool getPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
        JedisPool jedisPool = new JedisPool(config,ip,port,1000,pass);
        return jedisPool;
    }
    @Bean("jedis")
    public Jedis jedis(JedisPool jedisPool){
        return jedisPool.getResource();
    }
}


