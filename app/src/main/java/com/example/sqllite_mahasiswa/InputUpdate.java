package com.example.sqllite_mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InputUpdate extends AppCompatActivity {
    EditText edtTextNomor,edtTextNama,edtTextTglLahir,edtTextJenkel,edtTextAlamat;
    Button btn_simpan;
    DatabaseHelper SQLite = new DatabaseHelper(this);
    String nama,tgl_lahir,nomor,jenkel,alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_input_update);

        edtTextNomor = findViewById(R.id.edtTextNomor);
        edtTextNama = findViewById(R.id.edtTextNama);
        edtTextJenkel = findViewById(R.id.edtTextJenkel);
        edtTextTglLahir = findViewById(R.id.edtTextTglLahir);
        edtTextAlamat = findViewById(R.id.edtTextAlamat);

        nomor = getIntent().getStringExtra(DataMahasiswaActivity.KEY_NAMA);
    }
}
