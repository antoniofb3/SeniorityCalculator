package com.antoniofb.senioritycalculator.factors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, factors);

        lvFactors = (ListView) findViewById(R.id.factorsList);
        lvFactors.setAdapter(adapter);
    }
}
