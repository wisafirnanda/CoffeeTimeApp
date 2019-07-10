package com.coffeetimeapp.model;

public class WarkopTest {

    private String id, nama_warkop, nama_pemilik, cp_warkop, alamat_warkop, waktu_buka, menu;
    private Double longitude, latitude;

    public WarkopTest() {

    }

    public WarkopTest(String nama_warkop, String nama_pemilik, String cp_warkop, String alamat_warkop, String waktu_buka, String menu) {
        this.nama_warkop = nama_warkop;
        this.nama_pemilik = nama_pemilik;
        this.cp_warkop = cp_warkop;
        this.alamat_warkop = alamat_warkop;
        this.waktu_buka = waktu_buka;
        this.menu = menu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getnama_warkop() {
        return nama_warkop;
    }

    public void setnama_warkop(String nama_warkop) {
        this.nama_warkop = nama_warkop;
    }

    public String getnama_pemilik() {
        return nama_pemilik;
    }

    public void setnama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getcp_warkop() {
        return cp_warkop;
    }

    public void setcp_warkop(String cp_warkop) {
        this.cp_warkop = cp_warkop;
    }

    public String getalamat_warkop() {
        return alamat_warkop;
    }

    public void setalamat_warkop(String alamat_warkop) { this.alamat_warkop = alamat_warkop; }

    public String getwaktu_buka() { return waktu_buka; }

    public void setwaktu_buka(String waktu_buka) {
        this.waktu_buka = waktu_buka;
    }

    public String getmenu() {
        return menu;
    }

    public void setmenu(String menu) {
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
}
