package com.example.sqllite_mahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class DataMahasiswaActivity extends AppCompatActivity implements View.OnClickListener,RecyclerviewAdapter.OnUserClickListener{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    List<PersonBean> listPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);


        recyclerView= findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

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
    public void onClick(View view) {

    }

    @Override
    public void onUserClick(PersonBean currentPerson, String action) {

    }
}
