package com.critc.datasource;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by 孔垂云 on 2017/5/23.
 */

public class DBConnect {
    private Connection conn = null;
    private static DataSource dataSource;//定义数据源
    public static Properties dbProps = null;//定义参数配置
    public static String dbName;//定义默认的数据库
    public static Hashtable<String, DataSource> hmDataSource = new Hashtable<String, DataSource>();//定义多数据源的hashtable
    private final static Logger logger = LoggerFactory.getLogger(DBConnect.class);//定义日志

    static {
        InputStream is = DBConnect.class.getResourceAsStream("/db.properties");
        dbProps = new Properties();
        try {
            dbProps.load(is);
            dbName = dbProps.getProperty("defaultDb");
        } catch (Exception e) {
            logger.error("不能读取属性文件. " + "请确保db.properties在CLASSPATH指定的路径中");
        }
    }

    public static DataSource getdataSource() {
        return dataSource;
    }

    /**
     * 构造数据库的连接和访问类
     */
    public DBConnect(String dbName) {
        initializeDataSource(dbName);
    }

    /**
     * 无参数构造方法，默认找ldtj数据源
     */
    public DBConnect() {
        initializeDataSource(dbName);
    }

    private void initializeDataSource(String dbName) {
        dataSource = hmDataSource.get(dbName);
        if (dataSource == null)// 建立数据库连接
        {
            String dbPool = dbProps.getProperty(dbName + ".dbPool");
            if (dbPool.equalsIgnoreCase("weblogic")) {
                String weblogic_pool = dbProps.getProperty(dbName + ".weblogic.poolName");
                Context ctx = null;
                Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
                ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
                try {
                    ctx = new InitialContext(ht);
                    dataSource = (DataSource) ctx.lookup(weblogic_pool);
                } catch (Exception e) {
                    logger.error("数据库连接失败");
                    e.printStackTrace();
                }
            } else if (dbPool.equalsIgnoreCase("druid")) {
                try {
                    Hashtable<String, String> map = new Hashtable<String, String>();
                    map.put("driverClassName", dbProps.getProperty(dbName + ".driverClassName"));
                    map.put("url", dbProps.getProperty(dbName + ".url"));
                    map.put("username", dbProps.getProperty(dbName + ".username"));
                    map.put("password", dbProps.getProperty(dbName + ".password"));
                    map.put("initialSize", dbProps.getProperty(dbName + ".initialSize"));
                    map.put("maxActive", dbProps.getProperty(dbName + ".maxActive"));

                    map.put("timeBetweenEvictionRunsMillis", "60000");
                    map.put("minEvictableIdleTimeMillis", "300000");
                    map.put("validationQuery", "SELECT 1 FROM DUAL");
                    map.put("testWhileIdle", "true");
                    map.put("testOnBorrow", "false");
                    map.put("testOnReturn", "false");
                    map.put("removeAbandoned", "true");
                    map.put("removeAbandonedTimeout", "1800");
                    map.put("logAbandoned", "true");
                    DruidDataSourceFactory.createDataSource(map);
                    dataSource = DruidDataSourceFactory.createDataSource(map);
                } catch (Exception e) {
                    dataSource = null;
                    logger.error("数据库连接失败");
                    e.printStackTrace();
                }
            }
            hmDataSource.put(dbName, dataSource);
        }
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("数据库连接失败:" + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBConnect dbc = new DBConnect();
        System.out.println(dbc.getConnection());//连接第一个
        dbc.close();
        DBConnect dbc2 = new DBConnect("test2");
        System.out.println(dbc2.getConnection());//连接第二个
        dbc2.close();
    }

}
