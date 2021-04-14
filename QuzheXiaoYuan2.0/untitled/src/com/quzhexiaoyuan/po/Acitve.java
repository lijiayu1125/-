package com.quzhexiaoyuan.po;

public class Acitve {
    private int act_Id;//编号
    private String activeName;//活动名
    private String activeContent;//活动内容
    private String activeType;//活动类型
    private String activeplace;//活动地点
    private String activeTime;//活动时间
    private int activeGive;//活动时长给予
    private int activelimit;//活动人数上限


    public int getAct_Id() {
        return act_Id;
    }

    public void setAct_Id(int act_Id) {
        this.act_Id = act_Id;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getActiveContent() {
        return activeContent;
    }

    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent;
    }

    public String getActiveType() {
        return activeType;
    }

    public void setActiveType(String activeType) {
        this.activeType = activeType;
    }

    public String getActiveplace() {
        return activeplace;
    }

    public void setActiveplace(String activeplace) {
        this.activeplace = activeplace;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public int getActiveGive() {
        return activeGive;
    }

    public void setActiveGive(int activeGive) {
        this.activeGive = activeGive;
    }

    public int getActivelimit() {
        return activelimit;
    }

    public void setActivelimit(int activelimit) {
        this.activelimit = activelimit;
    }
}
