package com.critc;


import org.apache.log4j.Logger;

/**
 * Created by 孔垂云 on 2017/4/17.
 * Log4J使用
 */
public class Log4JTest {
    private static Logger logger = Logger.getLogger(Log4JTest.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("debug消息.");
        // 记录info级别的信息
        logger.info("info消息.");
        // 记录error级别的信息
        logger.error("error消息.");
    }
}
