package com.ironghui.datatree.activity.helper;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ironghui.datatree.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateDbActivity extends AppCompatActivity {
    @BindView(R.id.insert)
    Button createDb;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.peesonquery)
    Button peesonquery;
    @BindView(R.id.persondelete)
    Button persondelete;
    @BindView(R.id.personupdate)
    Button personupdate;
    @BindView(R.id.personAdd)
    Button personAdd;
    private Context mContext;
    private SQLiteDatabase db;
    private LianxirenOperator lianxirenOperator;
    private LianxirenOpenHelper dbHelper;
    private String name = "lxrData";
    private PersonDao personDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.createdb);
        ButterKnife.bind(this);
        requestPermission();
        dbHelper = new LianxirenOpenHelper(this, name, null, 1);
        db = dbHelper.getWritableDatabase();
        lianxirenOperator = new LianxirenOperator(this);
        personDao = new PersonDao(this);
    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
    }


    @OnClick({R.id.insert, R.id.delete, R.id.update, R.id.query, R.id.peesonquery, R.id.persondelete, R.id.personupdate, R.id.personAdd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insert:
                LianxirenBean lxr = new LianxirenBean();
                lxr.setName("李36四");
                lxr.setNumber("88");
                lxr.setIntroduce("1.2.0");
                ContentValues values = new ContentValues();
                values.put("name", "李336四");
                values.put("number", "838");
                values.put("introduce", "查宁introduce");
                db.insert(name, null, values);
                Toast.makeText(this, "l+xrData" + "添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                LianxirenBean lisi = lianxirenOperator.queryOne("李336四");
                lianxirenOperator.delete("李336四");
                Toast.makeText(this, lisi + "删除单一名字", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
              /*  LianxirenBean lxr2 = new LianxirenBean();
                lxr2.setName("lxr2name");
                lxr2.setNumber("lxr2number");
                lxr2.setIntroduce("lxr2introduce");
                lianxirenOperator.update(lxr2);*/

                ContentValues cv = new ContentValues();
                cv.put("name", "小春-鳗鱼");
//where 子句 "?"是占位符号，对应后面的"1",
                String whereClause = "name=?";
                String[] whereArgs = {"李336四"};
//参数1 是要更新的表名
//参数2 是一个ContentValeus对象
//参数3 是where子句
                db.update(name, cv, whereClause, whereArgs);
                Toast.makeText(this, "update", Toast.LENGTH_SHORT).show();
                break;
            case R.id.query:
//                Cursor cursor = db.query(name, new String[]{"name", "number", "introduce"}, "name=?", new String[]{"李336四"}, null, null, null);
//                Cursor cursor = db.rawQuery("select * from lxrData where name= ?", new String[]{"李336四"});
                Cursor cursor = db.rawQuery("select * from lxrData ", null);//报错
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    String introduce = cursor.getString(cursor.getColumnIndex("introduce"));
                    System.out.println("query------->" + "姓名：" + name + " " + "年龄：" + number + " " + "性别：" + introduce);
                }
                cursor.close();
                break;

        }
    }
}


