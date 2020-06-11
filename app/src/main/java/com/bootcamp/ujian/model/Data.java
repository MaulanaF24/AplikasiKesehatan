package com.bootcamp.ujian.model;

import com.bootcamp.ujian.application.AppController;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppController.class)
public class Data extends BaseModel {


    @PrimaryKey
    private String nama;
    @Column
    private int umur;
    @Column
    private int beratBadan;
    @Column
    private String tekananDarah;
    @Column
    private String alamat;

    public Data() {

    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(int beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getTekananDarah() {
        return tekananDarah;
    }

    public void setTekananDarah(String tekananDarah) {
        this.tekananDarah = tekananDarah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
