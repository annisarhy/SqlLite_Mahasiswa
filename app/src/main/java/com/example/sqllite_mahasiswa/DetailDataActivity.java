package com.example.sqllite_mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetailDataActivity extends AppCompatActivity {

    EditText etNomor,etNama,etTglLahir,etJenkel,etAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        etNomor = findViewById(R.id.edtTextNomor);
        etNama = findViewById(R.id.edtTextNama);
        etTglLahir = findViewById(R.id.edtTextTglLahir);
        etJenkel = findViewById(R.id.edtTextJenkel);
        etAlamat = findViewById(R.id.edtTextAlamat);

        etNomor.setFocusable(false);
        etNama.setFocusable(false);
        etTglLahir.setFocusable(false);
        etJenkel.setFocusable(false);
        etAlamat.setFocusable(false);
    }
}
