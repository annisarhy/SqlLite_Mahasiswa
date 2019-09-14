package com.example.sqllite_mahasiswa;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonBean implements Parcelable {
    int nomor;

    String nama,tgl_lahir,jenkel,alamat;

    public PersonBean(){

    }

    protected PersonBean(Parcel in) {
        nomor = in.readInt();
        nama = in.readString();
        tgl_lahir = in.readString();
        jenkel = in.readString();
        alamat = in.readString();
    }

    public static final Creator<PersonBean> CREATOR = new Creator<PersonBean>() {
        @Override
        public PersonBean createFromParcel(Parcel in) {
            return new PersonBean(in);
        }

        @Override
        public PersonBean[] newArray(int size) {
            return new PersonBean[size];
        }
    };

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {

        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(nomor);
        parcel.writeString(nama);
        parcel.writeString(tgl_lahir);
        parcel.writeString(jenkel);
        parcel.writeString(alamat);
    }
}
