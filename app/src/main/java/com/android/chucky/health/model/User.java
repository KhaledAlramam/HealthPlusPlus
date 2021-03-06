package com.android.chucky.health.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("username")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("token")
    private String authToken;

    private double lat;

    private double lang;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
