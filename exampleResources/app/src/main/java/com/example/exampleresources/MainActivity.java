package com.example.exampleresources;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnImg = findViewById(R.id.imageSelBtn);
        btnImg.setOnClickListener(l -> abrirCamara());
    }

    private static final int REQUEST_IMAGE_CAPTURE = 2;

    private void abrirCamara(){
        Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intentCamara, REQUEST_IMAGE_CAPTURE, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){

            Bundle info = data.getExtras();
            Bitmap image = (Bitmap) info.get("data");

            ImageView foto = findViewById(R.id.mostrarImagen);
            foto.setImageBitmap(image);
        }
    }
}