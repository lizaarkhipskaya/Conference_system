package model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
public class ConnectionPool {
        private volatile static DataSource dataSource;

        private ConnectionPool(){}

    public static DataSource getDatasource(){
        if (dataSource == null) {
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                    System.out.println("theere");
                    Properties properties = new Properties();
                    properties.setProperty("characterEncoding", "utf8");
                    PoolProperties p = new PoolProperties();
                    p.setUrl("jdbc:mysql://localhost:3306/conference_system");
                    p.setDriverClassName("com.mysql.jdbc.Driver");
                    p.setUsername("root");
                    p.setPassword("password");
                    p.setJmxEnabled(true);
                    p.setTestWhileIdle(false);
                    p.setTestOnBorrow(true);
                    p.setValidationQuery("SELECT 1");
                    p.setTestOnReturn(false);
                    p.setValidationInterval(30000);
                    p.setTimeBetweenEvictionRunsMillis(30000);
                    p.setMaxActive(100);
                    p.setInitialSize(10);
                    p.setMaxWait(10000);
                    p.setRemoveAbandonedTimeout(60);
                    p.setMinEvictableIdleTimeMillis(30000);
                    p.setMinIdle(10);
                    p.setLogAbandoned(true);
                    p.setRemoveAbandoned(true);
                    p.setDbProperties(properties);
                    p.setJdbcInterceptors(
                            "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                                    "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
                    dataSource = new DataSource();
                    dataSource.setPoolProperties(p);
                }
            }

        }
        return dataSource;
    }

}