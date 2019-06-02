package com.tim.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@MapperScan(basePackages = "com.tim.dao.oracle",sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class OracleSourceConfig {
    @Value("${oracle.datasource.filters}")
    private String filters;
    @Value("${oracle.datasource.driverClassName}")
    private String driverClassName;
    @Value("${oracle.datasource.url}")
    private String url;
    @Value("${oracle.datasource.username}")
    private String username;
    @Value("${oracle.datasource.password}")
    private String password;
    @Value("${oracle.datasource.initialSize}")
    private int initialSize;
    @Value("${oracle.datasource.minIdle}")
    private int minIdle;
    @Value("${oracle.datasource.maxActive}")
    private int maxActive;
    @Value("${oracle.datasource.maxWait}")
    private int maxWait;
    @Value("${oracle.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${oracle.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${oracle.datasource.validationQuery}")
    private String validationQuery;
    @Value("${oracle.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${oracle.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${oracle.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${oracle.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${oracle.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;



    @Bean(name = "oracleDataSource")
    public DataSource primaryDataSource() throws SQLException {
        DruidDataSource druid = new DruidDataSource();
        // 监控统计拦截的filters
        druid.setFilters(filters);

        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);

        //初始化时建立物理连接的个数
        druid.setInitialSize(initialSize);
        //最大连接池数量
        druid.setMaxActive(maxActive);
        //最小连接池数量
        druid.setMinIdle(minIdle);
        //获取连接时最大等待时间，单位毫秒。
        druid.setMaxWait(maxWait);
        //间隔多久进行一次检测，检测需要关闭的空闲连接
        druid.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //一个连接在池中最小生存的时间
        druid.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        //用来检测连接是否有效的sql
        druid.setValidationQuery(validationQuery);
        //建议配置为true，不影响性能，并且保证安全性。
        druid.setTestWhileIdle(testWhileIdle);
        //申请连接时执行validationQuery检测连接是否有效
        druid.setTestOnBorrow(testOnBorrow);
        druid.setTestOnReturn(testOnReturn);
        //是否缓存preparedStatement，也就是PSCache，oracle设为true，mysql设为false。分库分表较多推荐设置为false
        druid.setPoolPreparedStatements(poolPreparedStatements);
        // 打开PSCache时，指定每个连接上PSCache的大小
        druid.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        return druid;
    }


    @Bean(name = "oracleTransaction")
    public DataSourceTransactionManager primaryTransaction() throws SQLException {
        return new DataSourceTransactionManager(primaryDataSource());
    }


    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("oracleDataSource") DataSource primaryDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(primaryDataSource);  // 设置数据源bean
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/oracle/*.xml"));  // 设置mapper文件路径

        return sessionFactory.getObject();
    }

}

