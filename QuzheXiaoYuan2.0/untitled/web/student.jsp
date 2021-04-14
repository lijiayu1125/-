<%--
  Created by IntelliJ IDEA.
  User: Jyuu
  Date: 2021/4/13
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.quzhexiaoyuan.po.User"%>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>学生用户界面</title>
</head>
<body>
    <%
        //获取登录成功的用户信息
        User user = (User) session.getAttribute("user");
        //判断用户是否登录
        if(user != null){
    %>

    <header>
        <div class="title">
            <span>用户操作界面</span>
        </div>
        <nav>
            <div class="userinfo">
                <ul>
                    <li><%=user.getUsername() %></li>
                    <li><%=user.getLevel() %></li>
                    <li><a href="UserExitServlet">退出登录</a></li>
                    <li><a href="login.html">返回首页</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <main>
        <%
            }else{
                response.sendRedirect("login.html");
            }
        %>



    </main>
</body>
</html>
