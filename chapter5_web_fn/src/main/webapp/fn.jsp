<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/21
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="com.critc.model.User" %>
<%--引入EL函数库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>EL函数库中的方法使用范例</title>
</head>

<body>
<h3>fn:toLowerCase函数使用范例：</h3>
<%--fn:toLowerCase函数将一个字符串中包含的所有字符转换为小写形式，并返回转换后的字符串，
它接收一个字符串类型的参数。fn:toLowerCase("")的返回值为空字符串--%>
<%--fn:toLowerCase("Www.CNBLOGS.COM") 的返回值为字符串“www.cnblogs.com” --%>
fn:toLowerCase("Www.CNBLOGS.COM")的结果是：${fn:toLowerCase("Www.CNBLOGS.COM")}
<hr/>
<h3>fn:toUpperCase函数使用范例：</h3>
<%--fn:toUpperCase函数将一个字符串中包含的所有字符转换为大写形式，并返回转换后的字符串，
它接收一个字符串类型的参数。fn:toUpperCase("")的返回值为空字符串--%>
fn:toUpperCase("cnblogs.com")的结果是：${fn:toUpperCase("cnblogs.com")}
<hr/>
<h3>fn:trim函数使用范例：</h3>
<%--fn:trim函数删除一个字符串的首尾的空格，并返回删除空格后的结果字符串，
它接收一个字符串类型的参数。需要注意的是，fn:trim函数不能删除字符串中间位置的空格。--%>
fn:trim(" cnblogs.com ")的结果是：${fn:trim("  cnblogs.com  ")}
<hr/>
<h3>fn:length函数使用范例：</h3>
<%--fn:length函数返回一个集合或数组大小，或返回一个字符串中包含的字符的个数，返回值为int类型。
fn:length函数接收一个参数，这个参数可以是<c:forEach>标签的items属性支持的任何类型，
包括任意类型的数组、java.util.Collection、java.util.Iterator、java.util.Enumeration、
java.util.Map等类的实例对象和字符串。
如果fn:length函数的参数为null或者是元素个数为0的集合或数组对象，则函数返回0；如果参数是空字符串，则函数返回0
--%>
<%
    List<String> list = Arrays.asList("1", "2", "3");
    request.setAttribute("list", list);
%>
fn:length(list)计算集合list的size的值是：${fn:length(list)}
<br/>
fn:length("cnblogs.com")计算字符串的长度是：${fn:length("cnblogs.com")}
<hr/>
<h3>fn:split函数使用范例：</h3>
<%--
fn:split函数以指定字符串作为分隔符，将一个字符串分割成字符串数组并返回这个字符串数组。
fn:split函数接收两个字符串类型的参数，第一个参数表示要分割的字符串，第二个参数表示作为分隔符的字符串
--%>
fn:split("cnblogs.com",".")[0]的结果是：${fn:split("cnblogs.com",".")[0]}
<hr/>
<h3>fn:join函数使用范例：</h3>
<%--
fn:join函数以一个字符串作为分隔符，将一个字符串数组中的所有元素合并为一个字符串并返回合并后的结果字符串。
fn:join函数接收两个参数，第一个参数是要操作的字符串数组，第二个参数是作为分隔符的字符串。
如果fn:join函数的第二个参数是空字符串，则fn:join函数的返回值直接将元素连接起来。
--%>
<%
    String[] StringArray = {"www", "iteye", "com"};
    pageContext.setAttribute("StringArray", StringArray);
%>
<%--fn:join(StringArray,".")返回字符串“www.iteye.com”--%>
fn:join(StringArray,".")的结果是：${fn:join(StringArray,".")}
<br/>
<%--fn:join(fn:split("www,iteye,com",","),".")的返回值为字符串“www.iteye.com”--%>
fn:join(fn:split("www,iteye,com",","),".")的结果是：${fn:join(fn:split("www,iteye,com",","),".")}
<hr/>

<h3>fn:indexOf函数使用范例：</h3>
<%--
fn:indexOf函数返回指定字符串在一个字符串中第一次出现的索引值，返回值为int类型。
fn:indexOf函数接收两个字符串类型的参数，如果第一个参数字符串中包含第二个参数字符串，
那么，不管第二个参数字符串在第一个参数字符串中出现几次，fn:indexOf函数总是返回第一次出现的索引值；
如果第一个参数中不包含第二个参数，则fn:indexOf函数返回-1。如果第二个参数为空字符串，则fn:indexOf函数总是返回0。
--%>
fn:indexOf("www.iteye.com","eye")的返回值为：${fn:indexOf("www.iteye.com","eye")}
<hr/>

<h3>fn:contains函数使用范例：</h3>
<%--
fn:contains函数检测一个字符串中是否包含指定的字符串，返回值为布尔类型。
fn:contains函数在比较两个字符串是否相等时是大小写敏感的。
fn:contains函数接收两个字符串类型的参数，如果第一个参数字符串中包含第二个参数字符串，则fn:contains函数返回true，否则返回false。
如果第二个参数的值为空字符串，则fn:contains函数总是返回true。
实际上，fn:contains(string, substring)等价于fn:indexOf(string, substring) != -1
忽略大小的EL函数：fn:containsIgnoreCase
--%>
<%
    User user = new User();
    String likes[] = {"sing", "dance"};
    user.setLikes(likes);
    //数据回显
    request.setAttribute("user", user);
%>
<%--使用el函数回显数据 --%>
<input type="checkbox" name="like"
       vlaue="sing" ${fn:contains(fn:join(user.likes,","),"sing")?'checked':''}/>唱歌
<input type="checkbox" name="like"
       value="dance"  ${fn:contains(fn:join(user.likes,","),"dance")?'checked':''}/>跳舞
<input type="checkbox" name="like"
       value="basketball" ${fn:contains(fn:join(user.likes,","),"basketball")?'checked':''}/>蓝球
<input type="checkbox" name="like"
       value="football"  ${fn:contains(fn:join(user.likes,","),"football")?'checked':''}/>足球
<hr/>

<h3>fn:startsWith函数和fn:endsWith函数使用范例：</h3>
<%--
fn:startsWith函数用于检测一个字符串是否是以指定字符串开始的，返回值为布尔类型。
fn:startsWith函数接收两个字符串类型的参数，如果第一个参数字符串以第二个参数字符串开始，则函数返回true，否则函数返回false。
如果第二个参数为空字符串，则fn:startsWith函数总是返回true。
与fn:startsWith函数对应的另一个EL函数为：fn:endsWith，用于检测一个字符串是否是以指定字符串结束的，返回值为布尔类型。
--%>
fn:startsWith("www.iteye.com","iteye")的返回值为：${fn:startsWith("www.iteye.com","iteye")}
<br/>
fn:endsWith("www.iteye.com","com")的返回值为：${fn:endsWith("www.iteye.com","com")}
<hr/>

<h3>fn:replace使用范例：</h3>
<%--
fn:replace函数将一个字符串中包含的指定子字符串替换为其它的指定字符串，并返回替换后的结果字符串。
fn:replace方法接收三个字符串类型的参数，第一个参数表示要操作的源字符串，第二个参数表示源字符串中要被替换的子字符串，
第三个参数表示要被替换成的字符串。
--%>
fn:replace("www iteye com ", " ", ".")的返回值为字符串：${fn:replace("www iteye com", " ", ".")}
<hr/>

<h3>fn:substring使用范例：</h3>
<%--
fn:substring函数用于截取一个字符串的子字符串并返回截取到的子字符串。
fn:substring函数接收三个参数，第一个参数是用于指定要操作的源字符串，第二个参数是用于指定截取子字符串开始的索引值，
第三个参数是用于指定截取子字符串结束的索引值，第二个参数和第三个参数都是int类型，其值都从0开始。
--%>
fn:substring("www.it315.org", 4, 9) 的返回值为字符串：${fn:substring("www.it315.org", 4, 9)}

<h3>fn:substringAfter函数和fn:substringBefore函数使用范例：</h3>
<%--
fn:substringAfter函数用于截取并返回一个字符串中的指定子字符串第一次出现之后的子字符串。
fn:substringAfter函数接收两个字符串类型的参数，第一个参数表示要操作的源字符串，第二个参数表示指定的子字符串
与之对应的EL函数为：fn:substringBefore
--%>
fn:substringAfter("www.it315.org",".")的返回值为字符串：${fn:substringAfter("www.it315.org",".")}
<br/>
fn:substringBefore("www.it315.org",".")的返回值为字符串：${fn:substringBefore("www.it315.org",".")}
<hr/>
</body>
</html>
