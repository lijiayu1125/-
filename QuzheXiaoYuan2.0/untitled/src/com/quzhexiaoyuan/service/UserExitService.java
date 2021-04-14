//package com.quzhexiaoyuan.service;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//public class UserExitService extends HttpServlet {
//    private static final long serialVersionUID =1L;
//
//    //退出登录
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取Session
//        HttpSession session = request.getSession();
//        session.invalidate();
//        //转发到login.html页面
//        response.sendRedirect("login.html");
//    }
//
//}
