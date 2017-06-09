package com.antoniofb.senioritycalculator.factors;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.antoniofb.senioritycalculator.R;

public class FEducationActivity extends AppCompatActivity {

    private ListView lvEducation;
    private String[] formalEducation = {"Incomplete Terciary Education", "Incomplete Bachelor", "Bachelor", "Graduated + Specialization", "Master"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feducation);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Formal Education");
        formalEducationList();
    }

    public void formalEducationList(){
        lvEducation = (ListView) findViewById(R.id.educationList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, formalEducation);
        lvEducation.setAdapter(adapter);
        lvEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(FEducationActivity.this, FactorsActivity.class));
                    Toast.makeText(FEducationActivity.this,"You choose " + formalEducation[0], Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
