package com.example.csci370_lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText inp;
    private TextView def;
    private String defName;
    private String savedName;
    private String sharedPref = "sharedPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        inp = findViewById(R.id.inp);
        def = findViewById(R.id.name);

        loadData();
        updateName();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                def.setText(inp.getText().toString());

                saveData();
            }
        });
    }

    protected void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPref, MODE_PRIVATE);
        sharedPreferences.edit().putString(defName, inp.getText().toString()).apply();
    }

    protected void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPref, MODE_PRIVATE);
        savedName = sharedPreferences.getString(defName, "Beevus");
    }

    protected void updateName() {
        def.setText(savedName);
    }
}
