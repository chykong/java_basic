package com.critc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
//@WebServlet(urlPatterns = {"/helloworldServet"})
public class HellowordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HellowordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**初始化方法
     * @see #init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("Servlet初期化");
    }

    /**
     * servlet销毁方法
     * @see #destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("Servlet销毁");
    }

    /**
     * get请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //2.重新定义doGet
        response.setContentType("text/html;charset=UTF-8");   //3.设置响应类型
        PrintWriter out = response.getWriter();   //4.取得响应输出对象
        String name = request.getParameter("name");   //5.取得请求参数
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1>Hello!" + name + "</h1>");   //6.数据输出到前端
        out.print("This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
