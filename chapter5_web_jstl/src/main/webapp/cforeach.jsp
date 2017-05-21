<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/21
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>JSTL: -- forEach标签实例</title>
</head>

<body>
<h4><c:out value="forEach实例"/></h4>
<%
    List<String>list = new ArrayList<String>();
    list.add(0, "贝贝");
    list.add(1, "晶晶");
    list.add(2, "欢欢");
    list.add(3, "莹莹");
    list.add(4, "妮妮");
    request.setAttribute("list", list);
%>
<B><c:out value="不指定begin和end的迭代：" /></B><br>
<%--不使用begin和end的迭代，从集合的第一个元素开始，遍历到最后一个元素。 --%>
<c:forEach var="fuwa" items="${list}">
    &nbsp;<c:out value="${fuwa}"/><br/>
</c:forEach>

<B><c:out value="指定begin和end的迭代：" /></B><br>
<%--指定begin的值为1、end的值为3、step的值为2，
    从第二个开始首先得到晶晶，每两个遍历一次，
    则下一个显示的结果为莹莹，end为3则遍历结束。 --%>
<c:forEach var="fuwa" items="${list}" begin="1" end="3" step="2">
    &nbsp;<c:out value="${fuwa}"/><br/>
</c:forEach>

<B><c:out value="输出整个迭代的信息：" /></B><br>
<%--指定varStatus的属性名为s，并取出存储的状态信息 --%>
<c:forEach var="fuwa"
           items="${list}"
           begin="3"
           end="4"
           varStatus="s"
           step="1">
    &nbsp;<c:out value="${fuwa}" />的四种属性：<br>
    &nbsp;&nbsp;&nbsp;&nbsp;所在位置，即索引：<c:out value="${s.index}" /><br>
    &nbsp;&nbsp;&nbsp;&nbsp;总共已迭代的次数：<c:out value="${s.count}" /><br>
    &nbsp;&nbsp;&nbsp;&nbsp;是否为第一个位置：<c:out value="${s.first}" /><br>
    &nbsp;&nbsp;&nbsp;&nbsp;是否为最后一个位置：<c:out value="${s.last}" /><br>
</c:forEach>
</body>
</html>
