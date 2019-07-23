package com.coffeetimeapp.model;

public class Menu {

    private String id_kopi;
    private String nama_kopi;
    private String jenis_kopi;
    private String harga_kopi;

    public Menu (String nama_kopi, String jenis_kopi, String harga_kopi) {
        //this.id_kopi = id_kopi;
        this.nama_kopi = nama_kopi;
        this.jenis_kopi = jenis_kopi;
        this.harga_kopi = harga_kopi;
    }

    public String getId_kopi() {
        return id_kopi;
    }

    public void setId_kopi(String id_kopi) {
        this.id_kopi = id_kopi;
    }

    public String getNama_kopi() {
        return nama_kopi;
    }

    public void setNama_kopi(String nama_kopi) {
        this.nama_kopi = nama_kopi;
    }

    public String getJenis_kopi() {
        return jenis_kopi;
    }

    public void setJenis_kopi(String jenis_kopi) {
        this.jenis_kopi = jenis_kopi;
    }

    public String getHarga_kopi() {
        return harga_kopi;
    }

    public void setHarga_kopi(String harga_kopi) {
        this.harga_kopi = harga_kopi;
    }

}
