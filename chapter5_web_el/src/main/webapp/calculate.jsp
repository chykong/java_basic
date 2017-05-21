<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/21
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.critc.model.User" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>el表达式运算符</title>
</head>

<body>
<h3>el表达式进行四则运算：</h3>
加法运算：${365+24}<br/>
减法运算：${365-24}<br/>
乘法运算：${365*24}<br/>
除法运算：${365/24}<br/>

<h3>el表达式进行关系运算：</h3>
<%--${user == null}和 ${user eq null}两种写法等价--%>
${user == null}<br/>
${user eq null}<br/>

<h3>el表达式使用empty运算符检查对象是否为null(空)</h3>
<%

    List<String> list = new ArrayList<String>();
    list.add("gacl");
    list.add("xdp");
    request.setAttribute("list", list);
%>
<%--使用empty运算符检查对象是否为null(空) --%>
<c:if test="${!empty(list)}">
    <c:forEach var="str" items="${list}">
        ${str}<br/>
    </c:forEach>
</c:if>
<br/>
<%
    List<String> emptyList = null;
%>
<%--使用empty运算符检查对象是否为null(空) --%>
<c:if test="${empty(emptyList)}">
    对不起，没有您想看的数据
</c:if>

<br/>

<h3>EL表达式中使用二元表达式</h3>
<%
    session.setAttribute("user", new User("孤傲苍狼"));
%>
${user==null? "对不起，您没有登陆 " : user.username}

<br/>

<h3>EL表达式数据回显</h3>
<%
    User user = new User();
    user.setGender("male");
    //数据回显
    request.setAttribute("user", user);
%>
<input type="radio" name="gender" value="male" ${user.gender=='male'?'checked':''}>男
<input type="radio" name="gender" value="female" ${user.gender=='female'?'checked':''}>女
<br/>65
</body>
</html>
