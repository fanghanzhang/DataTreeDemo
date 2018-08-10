package com.ironghui.datatree.DataBean;

import java.io.Serializable;

/**
 * Created by ZhangFangHan on 2018/3/7.
 */

public class Person implements Serializable {
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private int age ;

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
}
