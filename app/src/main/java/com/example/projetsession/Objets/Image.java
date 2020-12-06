package com.example.projetsession.Objets;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Image implements Serializable {

    @Expose
    private String id_image;
    @Expose
    private String id_voiture;
    @Expose
    private String title;
    @Expose
    private String path;

    public String getId_image() {
        return id_image;
    }

    public void setId_image(String id_image) {
        this.id_image = id_image;
    }

    public String getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(String id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
