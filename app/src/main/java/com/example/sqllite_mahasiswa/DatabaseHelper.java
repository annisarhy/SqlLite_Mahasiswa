package com.example.sqllite_mahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private  static  final int DB_VERSION=1;
    private  static  final String DB_NAME="UserInfo";
    private  static  final String TABLE_NAME="tbl_user";
    private  static  final String KEY_NOMOR="nomor";
    private  static  final String KEY_NAMA="nama";
    private  static  final String KEY_TANGGAL="tgl_lahir";
    private  static  final String KEY_JENKEL="jenkel";
    private  static  final String KEY_ALAMAT="alamat";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable="Create Table "+TABLE_NAME+"("+KEY_NOMOR+" INTEGER PRIMARY KEY,"+KEY_NAMA+" TEXT,"+KEY_TANGGAL+" TEXT,"+KEY_JENKEL+" TEXT,"+KEY_ALAMAT+" TEXT"+")";
        db.execSQL(createUserTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql=("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(PersonBean personBean){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NOMOR,personBean.getNomor());
        values.put(KEY_NAMA,personBean.getNama());
        values.put(KEY_TANGGAL,personBean.getTgl_lahir());
        values.put(KEY_JENKEL,personBean.getJenkel());
        values.put(KEY_ALAMAT,personBean.getAlamat());

        db.insert(TABLE_NAME,null,values);
    }

    public List<PersonBean> selectUserData(){
        ArrayList<PersonBean> userList=new ArrayList<PersonBean>();

        SQLiteDatabase db= getReadableDatabase();
        String[] columns={KEY_NOMOR,KEY_NAMA,KEY_TANGGAL,KEY_JENKEL,KEY_ALAMAT};

        Cursor c =db.query(TABLE_NAME,columns,null,null,null,null,null);

        while (c.moveToNext()){
            int nomor=c.getInt(0);
            String nama=c.getString(1);
            String jenkel=c.getString(3);
            String tanggal=c.getString(2);
            String alamat=c.getString(4);

            PersonBean personBean=new PersonBean();
            personBean.setNomor(nomor);
            personBean.setNama(nama);
            personBean.setTgl_lahir(tanggal);
            personBean.setJenkel(jenkel);
            personBean.setAlamat(alamat);

            userList.add(personBean);         }

        return  userList;
    }

    public  void  delete(int nomor){
        SQLiteDatabase db =getWritableDatabase();
        String whereClause=KEY_NOMOR+"='"+nomor+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }

    public void update(PersonBean personBean){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAMA,personBean.getNama());
        values.put(KEY_TANGGAL,personBean.getTgl_lahir());
        values.put(KEY_JENKEL,personBean.getJenkel());
        values.put(KEY_ALAMAT,personBean.getAlamat());

        String whereClause=KEY_NOMOR+"='"+personBean.getNomor()+"'";
        db.update(TABLE_NAME,values,whereClause,null);
    }
}

