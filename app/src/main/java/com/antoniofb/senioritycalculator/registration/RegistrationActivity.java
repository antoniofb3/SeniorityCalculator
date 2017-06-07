package com.antoniofb.senioritycalculator.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.antoniofb.senioritycalculator.R;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etEmployeeName, etEmployeeJob, etEmployeeSeniority;
    private Button btRegisterEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    private void init(){
        etEmployeeName = (EditText) findViewById(R.id.employeeName);
        etEmployeeJob = (EditText) findViewById(R.id.employeeJob);
        etEmployeeSeniority = (EditText) findViewById(R.id.employeeSeniority);

        //etEmployeeSeniority.setOnEditorActionListener();
    }
}
