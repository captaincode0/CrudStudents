package com.example.captaincode.crudstudents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    private Button btnedit, btndel;
    private Spinner spcarriers;
    private EditText etnocontrol, etname, etaddr;
    private RadioGroup rbsexgroup;
    private RadioButton rbsex;
    private int id;
    private StudentController studentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        studentController = new StudentController(getApplicationContext());

        btnedit = (Button) findViewById(R.id.btnedit);
        btndel = (Button) findViewById(R.id.btndel);
        spcarriers = (Spinner) findViewById(R.id.spinner);
        etnocontrol = (EditText) findViewById(R.id.etnocontrol);
        etname = (EditText) findViewById(R.id.etname);
        etaddr = (EditText) findViewById(R.id.etaddr);
        rbsexgroup = (RadioGroup) findViewById(R.id.radioGroup);

        Bundle bundle = getIntent().getExtras();
        String sex = bundle.getString("sex");

        rbsex = (RadioButton) findViewById(sex.equals("Masculino")?R.id.rbman:R.id.rbwoman);
        rbsex.setChecked(true);

        etname.setText(bundle.getString("name"));
        etnocontrol.setText(bundle.getString("nocontrol"));
        etaddr.setText(bundle.getString("address"));
        id = bundle.getInt("id");

        String[] options = {"ISC", "FN", "MC", "IEM", "IAER"};
        String carrier = bundle.getString("carrier");

        for(int i=0; i<options.length; i++){
            if(carrier.equals(options[i]) && i!=0){
                String tmp = options[0];
                options[0] = carrier;
                options[i] = tmp;
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        spcarriers.setAdapter(adapter);

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setName(etname.getText().toString());
                studentEntity.setNocontrol(etnocontrol.getText().toString());
                studentEntity.setCarrier(spcarriers.getSelectedItem().toString());
                studentEntity.setAddress(etaddr.getText().toString());
                rbsex = (RadioButton) findViewById(rbsexgroup.getCheckedRadioButtonId());
                studentEntity.setSex(rbsex.getText().toString());

                if(studentController.editStudent(studentEntity, id)){
                    Toast.makeText(getApplicationContext(), "Alumno editado con exito", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), ViewStudents.class));
                }
                else Toast.makeText(getApplicationContext(), "El alumno no pudo ser editado", Toast.LENGTH_SHORT).show();
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentController.delStudent(id)) {
                    Toast.makeText(getApplicationContext(), "El alumno fue eliminado con exito", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), ViewStudents.class));
                }
                else Toast.makeText(getApplicationContext(), "El alumno no pudo ser eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
