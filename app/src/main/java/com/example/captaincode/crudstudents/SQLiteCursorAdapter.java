package com.example.captaincode.crudstudents;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by captaincode on 11/05/16.
 */
public class SQLiteCursorAdapter extends CursorAdapter{
    public SQLiteCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    public SQLiteCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.viewstudentscontent, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvid = (TextView) view.findViewById(R.id.tvid),
            tvname = (TextView) view.findViewById(R.id.tvname),
            tvnocontrol = (TextView) view.findViewById(R.id.tvnocontrol),
            tvaddr = (TextView) view.findViewById(R.id.tvaddr),
            tvsex = (TextView) view.findViewById(R.id.tvsex),
            tvcarrier = (TextView) view.findViewById(R.id.tvcarrier);

        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String nocontrol = cursor.getString(cursor.getColumnIndex("nocontrol"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String address = cursor.getString(cursor.getColumnIndex("address"));
        String sex = cursor.getString(cursor.getColumnIndex("sex"));
        String carrier = cursor.getString(cursor.getColumnIndex("carrier"));

        tvid.setText(String.valueOf(id));
        tvname.setText(name);
        tvnocontrol.setText(nocontrol);
        tvaddr.setText(address);
        tvsex.setText(sex);
        tvcarrier.setText(carrier);
    }
}
