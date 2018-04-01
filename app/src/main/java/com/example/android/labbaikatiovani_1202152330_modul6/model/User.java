package com.example.android.labbaikatiovani_1202152330_modul6.model;

/**
 * Created by Labbaika Putri on 4/1/2018.
 */

public class User {
    String userID;
    String username;
    String email;

    public User(){}

    public User(String userID, String username, String email) {
        this.userID = userID;
        this.username = username;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
