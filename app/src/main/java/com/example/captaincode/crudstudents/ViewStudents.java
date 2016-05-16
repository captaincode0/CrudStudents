package com.example.captaincode.crudstudents;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewStudents extends AppCompatActivity {
    private ListView lvstudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);
        lvstudents = (ListView) findViewById(R.id.listView);
        StudentController scontroller = new StudentController(this);

        try{
            SQLiteCursorAdapter sqliteadapter = new SQLiteCursorAdapter(this, scontroller.getStudents());
            lvstudents.setAdapter(sqliteadapter);
        }
        catch(NullPointerException ex){
            Toast.makeText(this, "Se obtuvo un cursor nulo de la base de datos", Toast.LENGTH_LONG).show();
        }

        /*
        lvstudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), Edit.class);
                Cursor lvcursor = (Cursor) lvstudents.getItemAtPosition(position);

                Toast.makeText(view.getContext(), "0 id = "+String.valueOf(lvcursor.getInt(0)), Toast.LENGTH_SHORT).show();
                Toast.makeText(view.getContext(), "1 = "+String.valueOf(lvcursor.getString(1)), Toast.LENGTH_SHORT).show(); //name
                Toast.makeText(view.getContext(), "2 = "+String.valueOf(lvcursor.getString(2)), Toast.LENGTH_SHORT).show(); //sex
                Toast.makeText(view.getContext(), "3 = "+String.valueOf(lvcursor.getString(3)), Toast.LENGTH_SHORT).show(); //addr
                Toast.makeText(view.getContext(), "4 = "+String.valueOf(lvcursor.getString(4)), Toast.LENGTH_SHORT).show(); //nocontrol
                Toast.makeText(view.getContext(), "5 = "+String.valueOf(lvcursor.getString(5)), Toast.LENGTH_SHORT).show(); //carrier
            }
        });*/

        lvstudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), Edit.class);
                Cursor lvcursor = (Cursor) lvstudents.getItemAtPosition(position);

                intent.putExtra("id", lvcursor.getInt(0));
                intent.putExtra("nocontrol", lvcursor.getString(4));
                intent.putExtra("name", lvcursor.getString(1));
                intent.putExtra("address", lvcursor.getString(3));
                intent.putExtra("sex", lvcursor.getString(2));
                intent.putExtra("carrier", lvcursor.getString(5));
                startActivity(intent);
            }
        });
    }
}
