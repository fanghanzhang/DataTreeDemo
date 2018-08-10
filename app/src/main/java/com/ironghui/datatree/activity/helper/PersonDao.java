package com.ironghui.datatree.activity.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private MySqliteDataHelper sqliteHelper;
    private SQLiteDatabase db;

    public PersonDao(Context context) {
        sqliteHelper = new MySqliteDataHelper(context);
        db = sqliteHelper.getReadableDatabase();
    }

    //增加的方法
    public void add(String name) {
        //? 占位
        ContentValues values = new ContentValues();
        values.put("name", name);
        db.insert("person", null, values);

    }

    //查询
    public List<String> select() {
        //1.sql语句   2.条件的值   Cursor 游标
        Cursor rawQuery = db.rawQuery("select * from person", null);
        List<String> list = new ArrayList<>();
        //rawQuery.moveToNext() 移动到下一行读取
        while (rawQuery.moveToNext()) {
            //得到查询出来的值
            String name = rawQuery.getString(rawQuery.getColumnIndex("name"));
            System.out.println("名字：" + name);
            list.add(name);
        }
        return list;
    }

    //删除
    public void delete(String name) {

        db.delete("person", "name = ?", new String[]{name});

    }

    //修改
    public void update(String tj, String name, String sex) {
        //要去修改person中的name, sex,根据name 为 ？ 的 条件去修改
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("sex", sex);
        db.update("person", values, "name = ?", new String[]{tj});

    }

    public void DeleAll() {
        db.execSQL("DELETE FROM person");
    }
}
