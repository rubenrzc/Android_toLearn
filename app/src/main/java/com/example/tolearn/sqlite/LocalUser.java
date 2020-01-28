package com.example.tolearn.sqlite;

import android.content.ContentValues;

import java.io.Serializable;

public class LocalUser implements Serializable {

    private int id;
    private String username;
    private String pwd;
    private int remember;

    public LocalUser(String username, String pwd, int remember) {
        this.username = username;
        this.pwd = pwd;
        this.remember = remember;
    }

    public LocalUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRemember() {
        return remember;
    }

    public void setRemember(int remember) {
        this.remember = remember;
    }

    public ContentValues insertValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", getUsername());
        contentValues.put("pwd", getPwd());
        contentValues.put("remember", getRemember());
        return contentValues;
    }
}
