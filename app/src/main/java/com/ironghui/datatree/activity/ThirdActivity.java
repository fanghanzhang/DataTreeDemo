package com.ironghui.datatree.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.ironghui.datatree.R;

import java.io.File;

/**
 * Created by ZhangFangHan on 2018/3/5.
 */

public class ThirdActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_third);
        filePath = "testFilePath";
        testGetJson();
//        blooeanSdcardStore();
    }

    private boolean  blooeanSdcardStore() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    String filePath;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE) && grantResults[0]
                    == PackageManager.PERMISSION_GRANTED) {
                //用户同意
                test();
            } else {
                //用户不同意

            }
        }
    }
    private void test() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int checkSelfPermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (checkSelfPermission == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        File appDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/mPic");
        if (!appDir.exists()) {
            boolean isSuccess = appDir.mkdirs();
            Log.d("isSuccess:", "----------0------------------" + isSuccess);
        }
    }
    private void testGetJson() {

                File pathDb = Environment.getExternalStorageDirectory();
                File file = new File("/sdcard/aaa");
                if (file.exists()) {
                    file.delete();
                    System.out.println("创建成功");
                }else {
                    file.mkdirs();
                }
    }

}
