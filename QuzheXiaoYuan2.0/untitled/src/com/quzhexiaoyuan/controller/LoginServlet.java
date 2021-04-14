package com.quzhexiaoyuan.controller;

import com.quzhexiaoyuan.dao.UserDao_Imp;
import com.quzhexiaoyuan.po.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDao_Imp userDaoImp = new UserDao_Imp();
        User getUser = userDaoImp.userLogin(username, password);

        if (getUser != null){
            int type = getUser.getType();
            if (type == 1){//学生用户
                request.setAttribute("user",getUser);
                request.getRequestDispatcher("/successServlet").forward(request,response);
            }if (type == 2){//活动举办方用户
                request.setAttribute("user",getUser);
                request.getRequestDispatcher("/successServlet").forward(request,response);
            }if (type == 3){//管理员
                request.setAttribute("user",getUser);
                request.getRequestDispatcher("/successServlet").forward(request,response);
            }
        }else {
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }

    }
}
