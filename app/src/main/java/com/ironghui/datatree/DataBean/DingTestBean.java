package com.ironghui.datatree.DataBean;

/**
 * Created by ZhangFangHan on 2018/5/10.
 */

public class DingTestBean {
    private String name;
    private int number;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public DingTestBean(String name, int number, String time) {
        this.name = name;
        this.number = number;
        this.time = time;
    }


}
