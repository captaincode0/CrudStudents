package com.example.captaincode.crudstudents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by captaincode on 2/05/16.
 */
public class StudentController {
    public Context context;
    private HandlerDatabase dbhandler;
    private SQLiteDatabase db;

    public StudentController(Context context){
        this.context = context;
        dbhandler = new HandlerDatabase(this.context);
        db = dbhandler.getWritableDatabase();
    }

    public boolean addStudent(StudentEntity student){
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(HandlerDatabase.nocontrol, student.getNocontrol());
        contentvalues.put(HandlerDatabase.name, student.getName());
        contentvalues.put(HandlerDatabase.addr, student.getAddress());
        contentvalues.put(HandlerDatabase.sex, student.getSex());
        contentvalues.put(HandlerDatabase.carrier, student.getCarrier());
        android.util.Log.v("student", "adding student "+contentvalues.toString());
        long res = db.insert("student", HandlerDatabase.name, contentvalues);
        db.close();
        return res > 0;
    }

    public boolean editStudent(StudentEntity student, int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(HandlerDatabase.nocontrol, student.getNocontrol());
        contentValues.put(HandlerDatabase.name, student.getName());
        contentValues.put(HandlerDatabase.addr, student.getAddress());
        contentValues.put(HandlerDatabase.sex, student.getSex());
        contentValues.put(HandlerDatabase.carrier, student.getCarrier());
        android.util.Log.v("student", "Deleting student " + contentValues.toString());
        int res = db.update("student", contentValues, "id=" + String.valueOf(id), null);
        db.close();
        return res > 0;
    }

    public boolean delStudent(int id){
        return db.delete("student", "id="+String.valueOf(id), null) > 0;
    }

    public Cursor getStudents(){
        return db.rawQuery("select id as _id, name, sex, address, nocontrol, carrier from student", null);
    }
}
