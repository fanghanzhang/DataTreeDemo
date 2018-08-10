package com.ironghui.datatree.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.ironghui.datatree.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ZhangFangHan on 2018/4/20.
 */

public class SqliteOpenActivity extends AppCompatActivity {
    // 数据库存储路径
    String filePath = "/DataTree_sqlite/db/Catevalue.db";
    // 数据库存放的文件夹
    String pathStr = "/DataTree_sqlite/db";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqliteopenactivity);
        addPermission();
        openDatabase();
    }

    private SQLiteDatabase openDatabase() {
        File pathDb = Environment.getExternalStorageDirectory();
        File jhPath = new File(pathDb, filePath);
        if (jhPath.exists()) {
            // 存在则直接返回打开的数据库
            return SQLiteDatabase.openOrCreateDatabase(jhPath, null);
        } else {
            // 不存在先创建文件夹
            File path = new File(pathDb, pathStr);
            if (path.mkdirs()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }

        return openDatabase();
    }

    private void addPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
    }
}
