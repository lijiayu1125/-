package com.quzhexiaoyuan.po;

public class Student extends User{
    private int stu_Id;//编号
    private String stunum;//学号
    private String stuName;//姓名
    private String major;//专业
    private int time;//时长


    public int getStu_Id() {
        return stu_Id;
    }

    public void setStu_Id(int stu_Id) {
        this.stu_Id = stu_Id;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
