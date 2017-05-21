<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/21
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%--引入EL自定义函数库 --%>
<%@taglib uri="/ELFunction" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>使用EL调用Java方法</title>
</head>

<body>
<%--使用EL调用filter方法--%>

${fn:filter("<a href=''>点点</a>")}

</body>
</html>
