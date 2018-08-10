package com.ironghui.datatree.activity.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MySqliteDataHelper extends SQLiteOpenHelper {
    private Context mContext;

    public MySqliteDataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    public MySqliteDataHelper(Context context) {
        super(context, "book", null, 1);
    }

    public static final String CREATE_BOOK = "create table book (" + "id integer primary key autoincrement, " + "author text, "

            + "price real, "

            + "pages integer, "

            + "name text)";

    public static final String person_dbNmae = "create table person(name varchar(200) ,sex varchar(10))";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(person_dbNmae);
//        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String CREATE_BOOK = "ALTER TABLE book add age integer";
       /* ContentValues mValues = new ContentValues();
        mValues.put("sex", "namevalue"); //key $ value
        mValues.put("age", "12");
        db.insert("book","nilai",mValues );*/
//        db.execSQL(CREATE_BOOK);

//        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }
}
