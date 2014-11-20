<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-10-21
  Time: 上午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello World~</title>
    <script type="text/javascript" src="include/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        $().ready(function () {
            alert('come to ajax');

            $("#btn01").click(function () {
                var username = $("#username").val();
//               alert(username.length);
                if (username.length == 0) {
                    alert('Please input account');
                } else {
                    $.post("/snail/ajaxUser", {username: username}, function (data) {
                        alert(data);
                    });
                }
            });

            $("#btn02").click(function () {
                var userId = $("#userId").val();

                alert(userId);
                $.post("/snail/ajaxModel", {userId: userId}, function (data) {
                    alert(data.id +"---" + data.username + "---" + data.password);
                }, "json");

            });
        });

    </script>
</head>
<body>
<h2>Start Spring MVC~ in index.jsp</h2>
<a href="hello">"href=hello"</a>

<form action="/snail/hello" method="post">
    Hello: <input type="text" name="hello"/>
    <input type="submit" value="提交"/>

    <p/>

</form>
<br/>
<hr>
Account:<input type="text" name="username" id="username"/>
<input type="button" id="btn01" value="validate"/>
<hr/>

<br/>
<hr>
User ID:<input type="text" name="userId" id="userId"/>
<input type="button" id="btn02" value="search"/>
<hr/>
<br/>
<shiro:user>
    <!-- shiro:principal打印出了Subject的主当事人 - 在这个示例中，就是用户名： -->
    <shiro:principal/>!

</shiro:user>
<shiro:guest>
    <!-- 没有登录 - 就认为是Guest。显示注册链接： -->
    ! <a href="register.jsp">Register today!</a>
</shiro:guest>
</body>
</html>