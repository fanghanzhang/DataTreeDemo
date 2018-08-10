package com.ironghui.datatree.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangFangHan on 2018/5/14.
 */

public class Contact {
    public String contact_name ;

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String contact_phone ;
    public int contact_id ;
    public String sortKey ;

    @Override
    public String toString() {
        return "Contact{" +
                "contact_name='" + contact_name + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", contact_id=" + contact_id +
                ", sortKey='" + sortKey + '\'' +
                '}';
    }




}
