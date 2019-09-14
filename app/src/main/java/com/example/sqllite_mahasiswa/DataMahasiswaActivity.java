package com.example.sqllite_mahasiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

public class DataMahasiswaActivity extends AppCompatActivity implements RecyclerviewAdapter.OnUserActionListener{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    List<PersonBean> listPersonInfo;
    LinearLayout foradd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        context = this;
        recyclerView= findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        foradd = findViewById(R.id.ForAdd);
        foradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context,InputUpdate.class);
                startActivity(pindah);
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView(){
        DatabaseHelper db = new DatabaseHelper(context);
        listPersonInfo = db.selectUserData();

        RecyclerviewAdapter adapter = new RecyclerviewAdapter(context,listPersonInfo,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onUserAction(final PersonBean personBean) {

        final CharSequence[] dialogItem = {"Lihat Detail", "Ubah Data", "Hapus Data"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pilihan");
        builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 1:
                        Intent detailData = new Intent(context,DetailDataActivity.class);
                        detailData.putExtra("DETAIL_DATA",personBean);
                        startActivity(detailData);
                        break;
                    case 2:
                        Intent updateData = new Intent(context,InputUpdate.class);
                        updateData.putExtra("UPDATE_INTENT",personBean);
                        updateData.putExtra("UPDATE_ACTION","Update");
                        startActivity(updateData);
                        break;
                    case 3:
                        DatabaseHelper db = new DatabaseHelper(context);
                        db.delete(personBean.getNomor());
                        setupRecyclerView();
                        break;
                }
            }
        });

         builder.create().show();

    }
}
