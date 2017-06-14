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

import java.util.ArrayList;
import java.util.List;

import layout.ExperienceFragment;
import layout.FormalEducationFragment;

public class FactorsActivity extends AppCompatActivity {

    private ListView lvFactors;
    private String[] factors = {"Formal Education", "Experience", "Management", "Communication", "Technical Skills", "Leadership Experience", "Empowerment"};
    private TextView tvEmpData;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Factors Screen");
        //actionBar.setBackgroundDrawable(new ColorDrawable());//to define action bar color
        showEmployeeData();//to show employee data in factor activity
        factorsList();
    }

    public void showEmployeeData(){
        Bundle bundle = getIntent().getExtras();
        String[] empData = {bundle.getString("Name"), bundle.getString("Job"), bundle.getString("Seniority")};
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeName);
        tvEmpData.setText(empData[0]);
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeJob);
        tvEmpData.setText(empData[1]);
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeSeniority);
        tvEmpData.setText(empData[2]);
    }

    public void factorsList(){
        lvFactors = (ListView) findViewById(R.id.factorsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, factors);
        lvFactors.setAdapter(adapter);
        mFragments = new ArrayList<>();
        mFragments.add(new FormalEducationFragment());
        mFragments.add(new ExperienceFragment());
        lvFactors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Fragment fragment;
                    fragment = mFragments.get(0);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,fragment).commit();
                }
                if (position == 1){
                    Fragment fragment;
                    fragment = mFragments.get(1);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, fragment).commit();
                }
            }
        });
    }
}
