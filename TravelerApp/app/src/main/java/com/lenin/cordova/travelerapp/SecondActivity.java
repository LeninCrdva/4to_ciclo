package com.lenin.cordova.travelerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String[] content = intent.getStringArrayExtra("contenido");
        if (content != null && content.length >= 3) {
            String user = content[0];
            String password = content[1];
            String date = content[2];
            String nation = content[3];

            TextView textViewUser = findViewById(R.id.showMesage);
            TextView textViewPassword = findViewById(R.id.passwordShow);
            TextView textViewBirthday = findViewById(R.id.birthdayShow);
            TextView textViewNation = findViewById(R.id.nationShow);

            textViewUser.setText(user);
            textViewPassword.setText(password);
            textViewBirthday.setText(date);
            textViewNation.setText(nation);
        }
    }
}