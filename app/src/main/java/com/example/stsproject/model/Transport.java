package com.example.stsproject.model;

import com.google.gson.annotations.SerializedName;

public class Transport {

    @SerializedName("nom")
    private String nom;
    @SerializedName("num")
    private int num;
    @SerializedName("image")
    private String imageURL;

    public Transport(String nom, int num, String imageURL) {
        this.nom = nom;
        this.num = num;
        this.imageURL = imageURL;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImageURL() {
        return "http://192.168.1.10/connexion_tst/transport/"+imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
