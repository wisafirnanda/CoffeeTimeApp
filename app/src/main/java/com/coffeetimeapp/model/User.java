package com.coffeetimeapp.model;

public class User {
    public User(String nama, String email, String noHp, String password) {
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.password = password;
    }

    private String uid, nama, email, noHp, password;

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
        this.password = password;
    }

}