package com.ironghui.datatree.activity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewStub;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ironghui.datatree.BuildConfig;
import com.ironghui.datatree.R;
import com.ironghui.datatree.dialog.DeleteDialog;
import com.ironghui.datatree.utils.MD5;

import java.io.File;

/**
 * Created by ZhangFangHan on 2018/4/8.
 */

public class FIlePermission extends AppCompatActivity {
     int reqCode = 0;
    private ViewStub viewStub;
    private String url;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_filepermission);
        inflaterView();
        //动态添加权限
        addPermission();
//        creatFile();
        url = BuildConfig.BASE_UR;//gradle中配置uri
//        getBuildUri();
        /*Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);*/
//        showDialog();
//        showReceiver();//监听屏幕的显示
        getMD5String();
    }

    private void getMD5String() {
        String str = "Zhang123";
        String md5 = MD5.ecodeByMD5(str);
    }

    MyReciever myReciever = new MyReciever();

    private void showReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);//屏幕监控的三个类型都得进行行为的action添加，少一个action少一个监听
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        registerReceiver(myReciever, filter);
    }

    private void getBuildUri() {
        requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                System.out.println(s.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(request);
    }

    private void creatFile() {
        String path = Environment.getExternalStorageDirectory() + "/zhiyuan.txt";
        File file = new File("/mnt/sdcard/work/mywork/a.txt");
        if (file.exists()) {
            file.delete();
            System.out.println("创建成功");
        } else {

            //通过file的mkdirs()方法创建<span style="color:#FF0000;">目录中包含却不存在</span>的文件夹
            file.mkdirs();


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        requestQueue.stop();
    }

    private void showDialog() {
        DeleteDialog dialog = new DeleteDialog(this, new DeleteDialog.DialogOnClickListener() {
            @Override
            public void deleteStatus(boolean delStatus) {
                if (delStatus) {
                    System.out.println("您已作出确定选择");
                }
            }
        });
        dialog.show();
        dialog.setTitle("提示");
        dialog.setMsg("您确定要退出程序吗?");
        System.out.println("创建失败");
    }

    private void addPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, reqCode);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0:
                System.out.println("onRequestPermissionsResult");
                File file = new File("a");
                if (file.exists()) {
                    System.out.println("创建成功");
                } else {
                    System.out.println("创建失败");
                }
        }
    }

    /**
     * VIewStup中必须嵌入布局xml android:layout="@layout/viewstup"
     */
    private void inflaterView() {
        viewStub = (ViewStub) findViewById(R.id.viewStup);
        viewStub.inflate();
        findViewById(R.id.viewstup_text);
    }
}
