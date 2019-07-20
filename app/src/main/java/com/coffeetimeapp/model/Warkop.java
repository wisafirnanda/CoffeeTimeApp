package com.coffeetimeapp.model;

public class Warkop {
    String nama_warkop;
    String nama_pemilik;
    String cp_warkop;
    String alamat_warkop;
    String waktu_buka;
    String menu;
    String key;

    private Double longitude, latitude;

    public Warkop(String nama_warkop, String nama_pemilik, String cp_warkop, String alamat_warkop, String waktu_buka, String key) {
        this.nama_warkop = nama_warkop;
        this.nama_pemilik = nama_pemilik;
        this.cp_warkop = cp_warkop;
        this.alamat_warkop = alamat_warkop;
        this.waktu_buka = waktu_buka;
        this.menu = menu;
        this.longitude = longitude;
        this.latitude = latitude;
        this.key= key;
    }

    public String getNama_warkop() {
        return nama_warkop;
    }

    public void setNama_warkop(String nama_warkop) {
        this.nama_warkop = nama_warkop;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getCp_warkop() {
        return cp_warkop;
    }

    public void setCp_warkop(String cp_warkop) {
        this.cp_warkop = cp_warkop;
    }

    public String getAlamat_warkop() {
        return alamat_warkop;
    }

    public void setAlamat_warkop(String alamat_warkop) {
        this.alamat_warkop = alamat_warkop;
    }

    public String getWaktu_buka() {
        return waktu_buka;
    }

    public void setWaktu_buka(String waktu_buka) {
        this.waktu_buka = waktu_buka;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
