package com.critc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 孔垂云 on 2017/4/17.
 * Logback测试
 */
public class LogBackTest {
    private final static Logger logger = LoggerFactory.getLogger(LogBackTest.class);
    public static void main(String[] args) {
        logger.info("输出Info");
        logger.error("输出Error");
    }
}
