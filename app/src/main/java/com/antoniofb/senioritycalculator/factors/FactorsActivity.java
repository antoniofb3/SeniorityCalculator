package com.antoniofb.senioritycalculator.factors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.senioritycalculator.R;

public class FactorsActivity extends AppCompatActivity {

    private ListView lvFactors;
    private String[] factors = {"Formal Education", "Experience", "Management", "Communication", "Technical Skills", "Leadership Experience", "Empowerment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        factorsList();
    }

    public void factorsList(){
        lvFactors = (ListView) findViewById(R.id.factorsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, factors);
        lvFactors.setAdapter(adapter);
        lvFactors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String value = (String)lvFactors
                if (position == 0){
                    startActivity(new Intent(FactorsActivity.this,FEducationActivity.class));
                }
            }
        });
    }
}
