package com.ironghui.datatree.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by ZhangFangHan on 2018/3/7.
 */

public class StoreNameAndPwd {

    public static HashMap<String, String> getNameAndPwd(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("zhangfanghan", 0);
        String usrName = sharedPreferences.getString("zhangfang", null);
        String usrPwd = sharedPreferences.getString("pwd", null);
        HashMap hashMap = new HashMap();
        hashMap.put("usrName", usrName);
        hashMap.put("usrPwd", usrPwd);

        return hashMap;
    }
}
