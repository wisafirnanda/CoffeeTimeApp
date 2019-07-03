package com.coffeetimeapp.model;

public class ListWarkopModel {
    public ListWarkopModel (){

    }

    public ListWarkopModel (String title, String price, String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.price = price;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
