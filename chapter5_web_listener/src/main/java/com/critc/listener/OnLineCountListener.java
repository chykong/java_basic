package com.critc.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 孔垂云 on 2017/5/21.
 * 统计在线人数
 */
public class OnLineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if (onLineCount == null) {
            context.setAttribute("onLineCount", 1);
        } else {
            onLineCount++;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if (onLineCount == null) {
            context.setAttribute("onLineCount", 1);
        } else {
            onLineCount--;
            context.setAttribute("onLineCount", onLineCount);
        }
    }
}
