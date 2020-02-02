package com.example.notepad;

public class noteItem {

    private int _id;
    private String title;

    public noteItem(){

    }

    public noteItem(int id, String t) {
        this._id = id;
        this.title = t;
    }

    public int getID() {
        return _id;
    }

    public void setID9(int id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String s) {
        this.title = s;
    }
}
