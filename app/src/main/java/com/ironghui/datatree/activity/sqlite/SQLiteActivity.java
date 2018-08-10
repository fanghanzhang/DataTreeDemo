package com.ironghui.datatree.activity.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ironghui.datatree.R;

public class SQLiteActivity extends AppCompatActivity {
    //声明各个按钮
    private Button createBtn;
    private Button insertBtn;
    private Button updateBtn;
    private Button queryBtn;
    private Button deleteBtn;
    private Button ModifyBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //调用creatView方法
        creatView();
//setListener方法
        setListener();
    }

    private void creatView() {
        createBtn = (Button) findViewById(R.id.createDatabase);
        updateBtn = (Button) findViewById(R.id.updateDatabase);
        insertBtn = (Button) findViewById(R.id.insert);
        ModifyBtn = (Button) findViewById(R.id.update);
        queryBtn = (Button) findViewById(R.id.query);
        deleteBtn = (Button) findViewById(R.id.delete);
    }

    private void setListener() {
        createBtn.setOnClickListener(new CreateListener());
        updateBtn.setOnClickListener(new UpdateListener());
        insertBtn.setOnClickListener(new InsertListener());
        ModifyBtn.setOnClickListener(new ModifyListener());
        queryBtn.setOnClickListener(new QueryListener());
        deleteBtn.setOnClickListener(new DeleteListener());
    }

    //创建数据库的方法
    class CreateListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
//创建StuDBHelper对象
            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this, "stu_db", null, 2);
//得到一个可读的SQLiteDatabase对象
            SQLiteDatabase db = dbHelper.getReadableDatabase();
        }
    }

    //更新数据库的方法
    class UpdateListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
// 数据库版本的更新,由原来的1变为2
            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this, "stu_db", null, 2);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
        }
    }

    //插入数据的方法
    class InsertListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this, "stu_db", null, 2);
//得到一个可写的数据库
            SQLiteDatabase db = dbHelper.getWritableDatabase();

//生成ContentValues对象 //key:列名，value:想插入的值
            ContentValues cv = new ContentValues();
//往ContentValues对象存放数据，键-值对模式
            cv.put("id", 1);
            cv.put("sname", "李三");
            cv.put("sage", 28);
            cv.put("ssex", "femail");
//调用insert方法，将数据插入数据库
            db.insert("stu_table", null, cv);
            Toast.makeText(SQLiteActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
//关闭数据库
            db.close();
        }
    }

    class QueryListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this, "stu_db", null, 2);
//得到一个可写的数据库
            SQLiteDatabase db = dbHelper.getReadableDatabase();
//参数1：表名
//参数2：要想显示的列
//参数3：where子句
//参数4：where子句对应的条件值
//参数5：分组方式
//参数6：having条件
//参数7：排序方式
            Cursor cursor = db.query("stu_table", new String[]{"id", "sname", "sage", "ssex"}, "id=?", new String[]{"1"}, null, null, null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("sname"));
                String age = cursor.getString(cursor.getColumnIndex("sage"));
                String sex = cursor.getString(cursor.getColumnIndex("ssex"));
                System.out.println("query------->" + "姓名：" + name + " " + "年龄：" + age + " " + "性别：" + sex);
            }
//关闭数据库
            db.close();
        }
    }

    //修改数据的方法
    class ModifyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this, "stu_db", null, 2);
//得到一个可写的数据库
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("sage", "33");
//where 子句 "?"是占位符号，对应后面的"1",
            String whereClause = "id=?";
            String[] whereArgs = {String.valueOf(1)};
//参数1 是要更新的表名
//参数2 是一个ContentValeus对象
//参数3 是where子句
            db.update("stu_table", cv, whereClause, whereArgs);

        }
    }

    //删除数据的方法
    class DeleteListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this, "stu_db", null, 2);
//得到一个可写的数据库
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String whereClauses = "id=?";
            String[] whereArgs = {String.valueOf(2)};
//调用delete方法，删除数据
            db.delete("stu_table", whereClauses, whereArgs);
        }
    }
}
