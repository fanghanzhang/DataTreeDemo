package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ironghui.datatree.R;
import com.ironghui.datatree.interfacen.GetData;
import com.ironghui.datatree.utils.GetDataUtils;
import com.ironghui.datatree.utils.SharedPreferenceDB;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by ZhangFangHan on 2018/3/8.
 */

public class ByteArrayActivity extends AppCompatActivity implements GetData {

    private SharedPreferenceDB sharedPreferenceDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytearray);
        byteArrayMethord();
        GetDataUtils.setGetDate(this);
        GetDataUtils.returnData();
        sharedPreferenceDB = GetSharedPreferenceActivity.getShareInstance(this);

        sharedPreferenceDB.setString("setString", "张三");
        sharedPreferenceDB.setString("setString2", "张三2");
        String getString = sharedPreferenceDB.getString("setString", null);
        String getString2 = sharedPreferenceDB.getString("setString2", null);
        addToast(this, R.string.get_data_false);
    }

    private void addToast(ByteArrayActivity context, int id) {
        Toast toast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(context);
        imageCodeProject.setImageResource(R.drawable.comm_error);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

    private void byteArrayMethord() {
        long befordDate = System.currentTimeMillis();
        byte[] str = "abcdefghijklmn".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(str);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StringBuffer sb = new StringBuffer();
        int temp = 0;
        int num = 0;
        while ((temp = bis.read()) != -1) {
            sb.append((char) temp);
            int upCase = Character.toUpperCase((char) temp);
            System.out.println(upCase);
            bos.write(upCase);
            num++;
        }
        try {
            bis.close();  //内存流无管道，关闭无效
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("d:" + File.separator + "a.txt");//File.separator是一个文件分隔符，在windows和linux平台下运行都没有问题
        long afterDate = System.currentTimeMillis();
        long duleDate = afterDate - befordDate;
        System.out.println(num);
        System.out.println(sb);
        System.out.println(duleDate);
    }

    @Override
    public void onEnd(String srring) {
        System.out.println("diaoyong方法成功");
    }

    @Override
    public void onStartde(String str) {
        System.out.println("diaoyong方法成功");
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            return true;
        }

        System.out.println("按下的监听");
        return super.onKeyDown(keyCode, event);
    }
}
