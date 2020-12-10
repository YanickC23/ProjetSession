package com.example.projetsession.Objets;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("response")
    private String response;

    public Image(String title, String image, String response) {
        this.title = title;
        this.image = image;
        this.response = response;
    }

    public String getResponse(){
        return response;
    }

}
