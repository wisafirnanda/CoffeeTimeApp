package com.coffeetimeapp.model;

public class User {

    private String uid, nama, email, noHp, password, tipe_user;

    public User(String nama, String email, String noHp, String password, String tipe_user) {
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.password = password;
        this.tipe_user = tipe_user;
    }

    public String getId() {
        return uid;
    }

    public void setId(String id) {
        this.uid = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; }

    public String getTipe_user() {
        return tipe_user;
    }

    public void setTipe_user(String tipe_user) {
        this.tipe_user = tipe_user;
    }

}