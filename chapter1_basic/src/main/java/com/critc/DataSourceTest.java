package com.critc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Hashtable;

/**
 * Created by 孔垂云 on 2017/4/17.
 * 连接池
 */
public class DataSourceTest {
    public static void main(String[] args)throws  Exception {
        Hashtable<String, String> map = new Hashtable<String, String>();
        map.put("driverClassName", "com.mysql.jdbc.Driver");
        map.put("url", "jdbc:mysql://127.0.0.1/test");
        map.put("username", "root");
        map.put("password", "root");
        map.put("initialSize", "2");
        map.put("maxActive", "10");
        DataSource dataSource = DruidDataSourceFactory.createDataSource(map);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Connection conn = dataSource.getConnection();
            conn.close();
        }
        System.out.println("连接池执行时间:" + (System.currentTimeMillis() - l));

        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Connection conn = new JdbcTest().getConn();
            conn.close();
        }
        System.out.println("JDBC连接执行时间:" + (System.currentTimeMillis() - l2));
    }

}
