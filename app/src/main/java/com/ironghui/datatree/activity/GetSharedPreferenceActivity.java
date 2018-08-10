package com.ironghui.datatree.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ironghui.datatree.interfacen.GetData;
import com.ironghui.datatree.utils.GetDataUtils;
import com.ironghui.datatree.utils.SharedPreferenceDB;
import com.ironghui.datatree.utils.StoreNameAndPwd;

import java.io.File;
import java.util.HashMap;

/**
 * Created by ZhangFangHan on 2018/3/7.
 */
public class GetSharedPreferenceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("zhangfanghan", 0);
        SharedPreferences preferenPeng = getSharedPreferences("pengmeng", 0);
        String strPeng = preferenPeng.getString("pengm", "");
        String str = sharedPreferences.getString("zhangfang", "");
        HashMap map = StoreNameAndPwd.getNameAndPwd(this);
        File file = new File("a.txt");
        if (!file.exists()){

            file.mkdir();
        }else {
            System.out.println("�����ɹ�");
        }

    }

    static SharedPreferenceDB sharedPreferenceDB;

//懒汉单例模式中需添加同步静态关键字
    public synchronized static SharedPreferenceDB getShareInstance(Context context) {

        if (sharedPreferenceDB == null) {
            sharedPreferenceDB = new SharedPreferenceDB(context);
        }
        return sharedPreferenceDB;
    }


}
