package com.ironghui.datatree.DataBean;

import java.io.Serializable;

/**
 * Created by ZhangFangHan on 2018/3/12.
 */

public class GirlFriend implements Serializable {
    //   根据对象属性值，创建对应的值
    private String name;
    private int age;
    //   setter getter方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //   toString方法用于控制台输出
    @Override
    public String toString() {
        return "GirlFriend [name=" + name + ", age=" + age + "]";
    }
}
