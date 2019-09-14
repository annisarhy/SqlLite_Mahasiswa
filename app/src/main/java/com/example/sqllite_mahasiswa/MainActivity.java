package com.example.sqllite_mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lihatdata(View view) {
        Intent explicit = new Intent(this, DataMahasiswaActivity.class);
        startActivity(explicit);
    }

    public void inputdata(View view) {
        Intent explicit = new Intent(this, InputUpdate.class);
        startActivity(explicit);
    }

    public void informasi(View view) {
        Intent explicit = new Intent(this, Informasi.class);
        startActivity(explicit);
    }
}
