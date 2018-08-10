package com.ironghui.datatree.activity.helper;

public class LianxirenBean {
    private String name;
    private String number;
    private String introduce;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public LianxirenBean() {
        super();
    }

    public LianxirenBean(String name, String number, String introduce) {
        super();
        this.name = name;
        this.number = number;
        this.introduce = introduce;
    }

}
