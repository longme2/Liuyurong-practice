<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/8
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
<img src="${pageContext.request.contextPath}/images/bgImg.jpg" class="bgImg" />
<div class="content">
    <div class="bidTitle">凯莱国际酒店管理系统</div>
    <div class="logCon">
        <form action="/HotelSystem/LoginAction.action" method="post">
            <div class="line"><span>账号:</span>
                <input class="bt_input" name="account" type="text" /></div>
            <div class="line"><span>密码:</span>
                <input class="bt_input" name="password" type="text" /></div>
            <input class="logingBut" type="submit" value="登陆">
        </form>
    </div>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
