package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.po.Acitve;

import java.util.ArrayList;

public interface ActiveDao {

    //查询所有活动，用ArrayList返回
    public ArrayList<Acitve> queryAllActive();

    //添加活动,添加成功返回true，失败返回false
    public boolean insertActive(String activeName,String activeContent,String activeType,String activeplace,String activeTime,int activeGive,int activelimit);

    //撤除活动，撤除成功返回true，失败返回false
    public boolean deleteActive(String activeName);

    //根据关键词搜索活动，用ArrayList返回
    public ArrayList<Acitve> queryKeyActive(String keyWord);


}
