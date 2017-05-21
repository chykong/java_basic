<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

当前在线人数：<%=session.getServletContext().getAttribute("onLineCount")%>
</body>
</html>
