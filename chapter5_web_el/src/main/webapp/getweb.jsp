<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/21
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>el隐式对象</title>
</head>

<body>
<br/>---------------1、pageContext对象：获取JSP页面中的pageContext对象------------------------<br/>
${pageContext}
<br/>---------------2、pageScope对象：从page域(pageScope)中查找数据------------------------<br/>
<%
    pageContext.setAttribute("name", "孤傲苍狼");  //map
%>
${pageScope.name}
<br/>---------------3、requestScope对象：从request域(requestScope)中获取数据------------------------<br/>
<%
    request.setAttribute("name", "白虎神皇");  //map
%>
${requestScope.name}
<br/>---------------4、sessionScope对象：从session域(sessionScope)中获取数据------------------------<br/>
<%
    session.setAttribute("user", "xdp");  //map
%>
${sessionScope.user}
<br/>---------------5、applicationScope对象：从application域(applicationScope)中获取数据------------------------<br/>
<%
    application.setAttribute("user", "gacl");  //map
%>
${applicationScope.user}

</body>
</html>