package com.lenin.cordova.travelerapp;

import static com.lenin.cordova.travelerapp.R.id.birthdayUser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOk = findViewById(R.id.sentButton);
        btnOk.setOnClickListener(l->enviarMensaje());
    }

    public void enviarMensaje() {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editTextMensaje = findViewById(R.id.userName);
        EditText editTextPassword = findViewById(R.id.passwordUser);
        EditText editTextFecha = findViewById(R.id.birthdayUser);
        Switch switchNational = findViewById(R.id.nationalQu);

        String nacionalidad = switchNational.isChecked() ? "Nacional" : "Extranjero";

        editTextFecha.setOnClickListener(l->showDatePickerDialog());

        String user = editTextMensaje.getText().toString();
        String password = editTextPassword.getText().toString();
        String fecha = editTextFecha.getText().toString();
        if(fecha.isEmpty() || user.isEmpty() || password.isEmpty() || nacionalidad.isEmpty()){
            Snackbar.make(findViewById(R.id.myConstraint), "Error, llene todos los campos", Snackbar.LENGTH_LONG).show();
            return;
        }
        intent.putExtra("contenido", new String[] {user, password, fecha, nacionalidad});
        startActivity(intent);  //Iniciamos el segundo activity
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                EditText editTextFecha = findViewById(R.id.birthdayUser);
                editTextFecha.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}