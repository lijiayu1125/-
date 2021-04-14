package com.quzhexiaoyuan.test;

import com.quzhexiaoyuan.dao.UserDao_Imp;
import com.quzhexiaoyuan.po.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test(){
        UserDao_Imp userDaoImp = new UserDao_Imp();
        User user = userDaoImp.userLogin("lijiayu", "123456");
        System.out.println(user.getType());
    }
}
