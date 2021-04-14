//package com.quzhexiaoyuan.service;
//
//import com.quzhexiaoyuan.po.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class RegisterService extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        int type = Integer.parseInt(request.getParameter("type"));
//
//        //实例化UserDao_Imp对象
//        UserDao_Imp userDaoImp = new UserDao_Imp();
//        User user = userDaoImp.userRegister(username, password,type);
//        //判断是否注册成功
//        if(user != null){//成功
//            if (type == 1) {//学生用户
//                request.getSession().setAttribute("student", user);//将学生用户放到session中
//                //转发到student.jsp中
//                request.getRequestDispatcher("student.jsp").forward(request, response);
//            }
//            if (type == 2){//活动举办方用户
//                request.getSession().setAttribute("sponsor", user);//将活动举办方用户放到session中
//                //转发到sponsor.jsp中
//                request.getRequestDispatcher("sponsor.jsp").forward(request, response);
//            }
//            if (type == 3){//管理员
//                request.getSession().setAttribute("manager", user);//将管理员放到session中
//                //转发到manager.jsp中
//                request.getRequestDispatcher("manager.jsp").forward(request, response);
//            }
//        }else {//失败
//            request.setAttribute("info"," 错误:已存在该用户,不能重复注册！");
//            request.getRequestDispatcher("message.jsp").forward(request, response);
//        }
//    }
//}
