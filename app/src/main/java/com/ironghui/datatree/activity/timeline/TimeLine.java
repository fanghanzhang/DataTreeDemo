package com.ironghui.datatree.activity.timeline;

public class TimeLine {
    private String  maddress;
    private String  mtime;

    public TimeLine( String address ,String time){

        this.maddress = address;
        this.mtime = time;
    }


    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }
}
