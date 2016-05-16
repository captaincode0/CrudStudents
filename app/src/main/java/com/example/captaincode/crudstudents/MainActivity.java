package com.example.captaincode.crudstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnsave;
    private Spinner spcarriers;
    private EditText etnocontrol, etname, etaddr;
    private RadioGroup rbsexgroup;
    private RadioButton rbsex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = (Button) findViewById(R.id.btnsave);
        spcarriers = (Spinner) findViewById(R.id.spinner);
        etnocontrol = (EditText) findViewById(R.id.etnocontrol);
        etname = (EditText) findViewById(R.id.etname);
        etaddr = (EditText) findViewById(R.id.etaddr);
        rbsexgroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnsave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        StudentEntity studentent = new StudentEntity();
        StudentController stcontroller = new StudentController(this);
        rbsex = (RadioButton) findViewById(rbsexgroup.getCheckedRadioButtonId());
        studentent.setSex(rbsex.getText().toString());
        studentent.setName(etname.getText().toString());
        studentent.setAddress(etaddr.getText().toString());
        studentent.setCarrier(spcarriers.getSelectedItem().toString());
        studentent.setNocontrol(etnocontrol.getText().toString());
        if(stcontroller.addStudent(studentent))
            Toast.makeText(this, "Alumno insertado con éxito", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error: el alumno no ha sido insertado", Toast.LENGTH_SHORT).show();
    }
}
