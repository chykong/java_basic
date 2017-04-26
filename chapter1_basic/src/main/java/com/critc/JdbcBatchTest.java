package com.critc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 孔垂云 on 2017/4/26.
 */
public class JdbcBatchTest {
    /**
     * 获取数据库连接
     *
     * @return
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "es", "es");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 批量新增
     */
    public void addBatch() {
        Connection conn = getConn();
        String sql = "insert into staff(name) values(?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            long l = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                pstmt.setString(1, "张三" + i);
                pstmt.addBatch();
                if (i % 30000 == 0)
                    pstmt.executeBatch();
            }
            pstmt.executeBatch();
            System.out.println("执行时间：" + (System.currentTimeMillis() - l));
            pstmt = null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new JdbcBatchTest().addBatch();
    }
}
