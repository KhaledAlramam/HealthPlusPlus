package com.android.chucky.health.model;

import com.google.gson.annotations.SerializedName;

public class Disease {

    private int id;

    private float diameter;

    private float lat;
    private float lang;

    @SerializedName("level_of_danger")
    private String levelOfDanger;

    private String owner;

    private String title;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLang() {
        return lang;
    }

    public void setLang(float lang) {
        this.lang = lang;
    }

    public String getLevelOfDanger() {
        return levelOfDanger;
    }

    public void setLevelOfDanger(String levelOfDanger) {
        this.levelOfDanger = levelOfDanger;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
