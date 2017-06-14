package com.antoniofb.senioritycalculator.factors;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.antoniofb.senioritycalculator.R;

import layout.ExperienceFragment;
import layout.FormalEducationFragment;

public class FactorsActivity extends AppCompatActivity {

    private ListView lvFactors;
    private String[] factors = {"Formal Education", "Experience", "Management", "Communication", "Technical Skills", "Leadership Experience", "Empowerment"};
    private TextView tvEmpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Factors Screen");
        //actionBar.setBackgroundDrawable(new ColorDrawable());//to define action bar color
        //showEmployeeData();//to show employee data in factor activity
        factorsList();
    }

    public void showEmployeeData(){
        //better to use singleton for persistant data???
        Bundle bundle = getIntent().getExtras();
        String empName;
        empName = bundle.getString("Name");
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeName);
        tvEmpData.setText(empName);
        //empName = bundle.getString("Job");
        //tvEmpData = (TextView) findViewById(R.id.tvEmployeeJob);
        //tvEmpData.setText(empName);

    }

    public void factorsList(){
        lvFactors = (ListView) findViewById(R.id.factorsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, factors);
        lvFactors.setAdapter(adapter);
        lvFactors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Fragment fragment;
                    fragment = new FormalEducationFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_place, fragment);
                    fragmentTransaction.commit();
                }
                if (position == 1){
                    Fragment fragment;
                    fragment = new ExperienceFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_place, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}
