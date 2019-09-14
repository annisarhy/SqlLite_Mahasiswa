package com.example.sqllite_mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputUpdate extends AppCompatActivity {
    EditText edtTextNomor, edtTextNama, edtTextTglLahir, edtTextJenkel, edtTextAlamat;
    Context context;
    Button btnSimpan;
    DatabaseHelper editdata;
    String nama, tgl_lahir, nomor, jenkel, alamat, submit;
    PersonBean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_update);
        context = this;

        edtTextNomor = findViewById(R.id.edtTextNomor);
        edtTextNama = findViewById(R.id.edtTextNama);
        edtTextJenkel = findViewById(R.id.edtTextJenkel);
        edtTextTglLahir = findViewById(R.id.edtTextTglLahir);
        edtTextAlamat = findViewById(R.id.edtTextAlamat);

        submit = getIntent().getStringExtra("UPDATE_ACTION");
        update = getIntent().getParcelableExtra("UPDATE_INTENT");
        if (submit == null) {
            submit = "Submit";
        } else {
            nomor = String.valueOf(update.getNomor());
        }

        if (submit.equals("Update")){
            btnSimpan.setText("Update");
            edtTextNomor.setText(nomor);
            edtTextNomor.setFocusable(false);
            edtTextNama.setText(update.getNama());
            edtTextTglLahir.setText(update.getTgl_lahir());
            edtTextJenkel.setText(update.getJenkel());
            edtTextAlamat.setText(update.getAlamat());

            Log.d("test",update.getNama());
        }
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                PersonBean data = new PersonBean();
                String label = btnSimpan.getText().toString();
                if (label.equals("Simpan")){
                    data.setNomor(Integer.parseInt(edtTextNomor.getText().toString()));
                    data.setNama(edtTextNama.getText().toString());
                    data.setTgl_lahir(edtTextTglLahir.getText().toString());
                    data.setJenkel(edtTextJenkel.getText().toString());
                    data.setAlamat(edtTextAlamat.getText().toString());
                    db.insert(data);
                    Intent move = new Intent(context,MainActivity.class);
                    context.startActivity(move);
                }
                if (label.equals("Update")){
                    data.setNomor(Integer.parseInt(edtTextNomor.getText().toString()));
                    data.setNama(edtTextNama.getText().toString());
                    data.setTgl_lahir(edtTextTglLahir.getText().toString());
                    data.setJenkel(edtTextJenkel.getText().toString());
                    data.setAlamat(edtTextAlamat.getText().toString());
                    db.update(data);
                    Intent move = new Intent(context,MainActivity.class);
                    context.startActivity(move);
                }
            }
        });

    }
}
