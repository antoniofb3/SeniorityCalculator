package com.antoniofb.senioritycalculator.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.antoniofb.senioritycalculator.R;
import com.antoniofb.senioritycalculator.factors.FEducationActivity;
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
        //String employeeName, employeeJob, employeeSeniority;
        if (isFormIsValidated()){
            /*
            employeeName = etEmployeeName.getText().toString();
            employeeJob = etEmployeeJob.getText().toString();
            employeeSeniority = etEmployeeSeniority.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("NAME", employeeName);
            bundle.putString("JOB", employeeJob);
            bundle.putString("JOB", employeeSeniority);
            */

            startActivity(new Intent(RegistrationActivity.this, FactorsActivity.class));
        }
    }

    public boolean isFormIsValidated(){
        if (!isEmployeeNameValid()){
            Toast.makeText(this,"Invalid employee name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!isEmployeeJobValid()){
            Toast.makeText(this,"Invalid employee job", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!isEmployeeSeniorityValid()){
            Toast.makeText(this,"Invalid employee seniority", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isEmployeeNameValid(){
        return !TextUtils.isEmpty(etEmployeeName.getText()); //|| !Patterns.PHONE.matcher(etEmployeeName.getText()).matches();
    }

    private boolean isEmployeeJobValid(){
        return !TextUtils.isEmpty(etEmployeeJob.getText());
    }

    private boolean isEmployeeSeniorityValid(){
        return !TextUtils.isEmpty(etEmployeeSeniority.getText());
    }
}
