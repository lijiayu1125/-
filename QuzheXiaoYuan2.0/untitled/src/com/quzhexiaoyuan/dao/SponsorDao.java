package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.po.Sponsor;
import com.quzhexiaoyuan.po.User;

import java.util.ArrayList;

public interface SponsorDao {

    //获取所有活动举办方的信息，用ArrayList返回
    public ArrayList<Sponsor> queryAllSponsor();

    //完善活动举办方信息,用户注册后，调用该方法,信息完善成功返回true，失败返回false
    public boolean sponsorInformation(String associationName, String introduction, String charge, String phoneNum, User user);

    //修改活动举办方信息，修改成功返回true，失败返回false
    public boolean alterSponsor(String associationName,String introduction,String charge,String phoneNum);

    //查询活动举办方个人信息，用User返回
    public User queryKeyStudent(String username);
}
