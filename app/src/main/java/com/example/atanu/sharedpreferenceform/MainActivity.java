package com.example.atanu.sharedpreferenceform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText username,password,time;

    CheckBox male , female , car , bike , remember_me;
    Button register;
    SharedPreferences SP;
    SharedPreferences.Editor editor;
    Boolean saveLogin , saveMale, saveFemale,saveCar, saveBike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        time = findViewById(R.id.et_time);
        car = findViewById(R.id.cb_car);
        bike = findViewById(R.id.cb_bike);
        male = findViewById(R.id.cb_male);
        female = findViewById(R.id.cb_female);
        remember_me = findViewById(R.id.cb_remember_me);
        register = findViewById(R.id.btn_register);

        SP = getSharedPreferences("loginref",MODE_PRIVATE);
        editor = SP.edit();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);

                SaveFunc();

            }
        });




        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.CountryList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void SaveFunc(){
        if(remember_me.isChecked()){
            editor.putBoolean("saveLogin",true);
            editor.putBoolean("male",male.isChecked());
            editor.putBoolean("female",female.isChecked());
            editor.putBoolean("car",car.isChecked());
            editor.putBoolean("bike",bike.isChecked());
            editor.putString("username",username.getText().toString());
            editor.putString("password",password.getText().toString());
            editor.putString("time",time.getText().toString());

            editor.apply();
            }

    }





}
