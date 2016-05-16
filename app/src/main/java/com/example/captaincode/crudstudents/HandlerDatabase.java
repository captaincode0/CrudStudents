package com.example.captaincode.crudstudents;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HandlerDatabase extends SQLiteOpenHelper{
    public static final String db="studentdb",
            nocontrol="nocontrol",
            name="name",
            addr="address",
            sex="sex",
            carrier="carrier";

    public HandlerDatabase(Context context){
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id integer primary key autoincrement not null, nocontrol text, name text, address text, sex text, carrier text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        android.util.Log.v("student", "upgrading to delete data");
        db.execSQL("drop table if exist student");
        onCreate(db);
    }
}
