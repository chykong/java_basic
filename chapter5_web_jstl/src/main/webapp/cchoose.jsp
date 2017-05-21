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
<!DOCTYPE HTML>
<html>
<head>
    <title>JSTL: -- choose及其嵌套标签标签示例</title>
</head>

<body>
<h4>choose及其嵌套标签示例</h4>
<hr/>
<%--通过set标签设定score的值为85 --%>
<c:set var="score" value="85"/>
<c:choose>
    <%--使用<c:when>进行条件判断。
        如果大于等于90，输出“您的成绩为优秀”；
        如果大于等于70小于90，输出“您的成绩为良好”；
        大于等于60小于70，输出“您的成绩为及格”；
        其他（otherwise）输出“对不起，您没能通过考试”。
     --%>
    <c:when test="${score>=90}">
        你的成绩为优秀！
    </c:when>
    <c:when test="${score>70 && score<90}">
        您的成绩为良好!
    </c:when>
    <c:when test="${score>60 && score<70}">
        您的成绩为及格
    </c:when>
    <c:otherwise>
        对不起，您没有通过考试！
    </c:otherwise>
</c:choose>
</body>
</html>
