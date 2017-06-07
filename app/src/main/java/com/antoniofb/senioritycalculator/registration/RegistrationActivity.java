package com.antoniofb.senioritycalculator.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.antoniofb.senioritycalculator.R;
import com.antoniofb.senioritycalculator.factors.FactorsActivity;

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
        btRegisterEmployee = (Button) findViewById(R.id.btnRegisterEmployee);

        etEmployeeSeniority.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    registerEmployee();
                    return true;
                }
                return false;
            }
        });

        btRegisterEmployee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                registerEmployee();
            }
        });

    }

    public void registerEmployee(){
        //if (formIsValidated()){
            startActivity(new Intent(RegistrationActivity.this, FactorsActivity.class));
        //}
    }
}
