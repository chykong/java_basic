package com.critc;

import com.critc.vo.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/4/17.
 * Jdbc测试
 */
public class JdbcTest {
    /**
     * 获取数据库连接
     *
     * @return
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 新增
     */
    public void add() {
        Connection conn = getConn();
        String sql = "insert into staff(name) values(?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "张三");
            pstmt.executeUpdate();
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

    /**
     * 修改
     */
    public void update() {
        Connection conn = getConn();
        String sql = "update staff set name=? where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "张三");
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
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

    /**
     * 删除
     */
    public void delete() {
        Connection conn = getConn();
        String sql = "delete from staff  where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 2);
            pstmt.executeUpdate();
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

    /***
     * 查询
     * @return
     */
    public List<Staff> query() {
        List<Staff> list = new ArrayList<>();
        Connection conn = getConn();
        String sql = "select * from  staff ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getString("name"));
                list.add(staff);

            }
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
        return list;
    }

    /**
     * 批量新增
     */
    public void addBatch() {
        Connection conn = getConn();
        String sql = "insert into staff(name) values(?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < 100; i++) {
                pstmt.setString(1, "张三" + i);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
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

    /**
     * 测试事务
     */
    public void testTransaction() {
        Connection conn = getConn();
        String sql = "insert into staff(name) values(?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "张三");
            pstmt.executeUpdate();
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setString(1, "张三22");
            pstmt2.executeUpdate();
            conn.commit();
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
        JdbcTest jdbcTest = new JdbcTest();
        Connection conn = jdbcTest.getConn();
        System.out.println("数据库连接：" + conn);
        jdbcTest.add();
        jdbcTest.update();
        jdbcTest.delete();
        jdbcTest.addBatch();
        List<Staff> list = jdbcTest.query();
        for (Staff staff : list) {
            System.out.println(staff.getName());
        }
        jdbcTest.testTransaction();
    }
}
