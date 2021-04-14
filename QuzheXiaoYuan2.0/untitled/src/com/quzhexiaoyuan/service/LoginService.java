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
//public class LoginService extends HttpServlet{
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        //实例化UserDao_Imp对象
//        UserDao_Imp userDaoImp = new UserDao_Imp();
//        User user = userDaoImp.userLogin(username, password);
//        //判断是否登录成功
//        if(user != null){//成功
//            int type = user.getType();
//            if(type == 1){//学生用户
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
//                request.getSession().setAttribute("manager", user);
//                //转发到manager.jsp中
//                request.getRequestDispatcher("manager.jsp").forward(request, response);
//             }else {//失败
//            request.setAttribute("info"," 错误:用户名或密码错误！");
//        }
//    }
//    }
//}
