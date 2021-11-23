package com.ardianhilmip.retrovolley.retrofit.model;

public class DataModel {

    private int id;
    private String nama, jabatan, no_telp, email, alamat, password;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
