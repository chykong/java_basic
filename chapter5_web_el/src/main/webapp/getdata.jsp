<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/21
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.critc.model.Person"%>
<%@page import="com.critc.model.Address"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>el表达式获取数据</title>
</head>

<body>
<%
    request.setAttribute("name","孤傲苍狼");
%>
<%--${name}等同于pageContext.findAttribute("name") --%>
使用EL表达式获取数据：${name}
<hr>
<!-- 在jsp页面中，使用el表达式可以获取bean的属性 -->
<%
    Person p = new Person();
    p.setAge(12);
    request.setAttribute("person",p);
%>
使用el表达式可以获取bean的属性：${person.age}
<hr>
<!-- 在jsp页面中，使用el表达式可以获取bean中的。。。。。。。。。的属性 -->
<%
    Person person = new Person();
    Address address = new Address();
    person.setAddress(address);

    request.setAttribute("person",person);
%>
${person.address.name}
<hr>
<!-- 在jsp页面中，使用el表达式获取list集合中指定位置的数据 -->
<%
    Person p1 = new Person();
    p1.setName("孤傲苍狼");

    Person p2 = new Person();
    p2.setName("白虎神皇");

    List<Person> list = new ArrayList<Person>();
    list.add(p1);
    list.add(p2);

    request.setAttribute("list",list);
%>

<!-- 取list指定位置的数据 -->
${list[1].name}

<!-- 迭代List集合 -->
<c:forEach var="person" items="${list}">
    ${person.name}
</c:forEach>
<hr>
<!-- 在jsp页面中，使用el表达式获取map集合的数据 -->
<%
    Map<String,String> map = new LinkedHashMap<String,String>();
    map.put("a","aaaaxxx");
    map.put("b","bbbb");
    map.put("c","cccc");
    map.put("1","aaaa1111");
    request.setAttribute("map",map);
%>

<!-- 根据关键字取map集合的数据 -->
${map.c}
${map["1"]}
<hr>
<!-- 迭代Map集合 -->
<c:forEach var="me" items="${map}">
    ${me.key}=${me.value}<br/>
</c:forEach>
<hr>
</body>
</html>
