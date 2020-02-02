package com.example.notepad;

public class Note {

    private int _id;
    private String title;
    private String content;
    private boolean has_bold = false;
    private boolean has_underlined = false;
    private boolean has_italics = false;
    private boolean has_text_color = false;
    private String bold_position;
    private String underlined_position;
    private String italics_position;
    private String color_position;

    public Note() {}

    public Note(int id) {
        this._id = id;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return _id;
    }

    public void setTitle(String s) {
        title = s;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String c) {
        this.content = c;
    }

    public String getContent() {
        return content;
    }

    public void setHasBold(boolean b) {
        has_bold = b;
    }

    public boolean getHasBold() {
        return has_bold;
    }

    public void setHasUnderlined(boolean b) {
        has_underlined = b;
    }

    public boolean getHasUnderlined() {
        return has_underlined;
    }

    public void setHasitalics(boolean b) {
        has_italics = b;
    }

    public boolean getHasItalics() {
        return has_italics;
    }

    public void setHasTextColor(boolean b) {
        has_text_color = b;
    }

    public boolean getHasTextColor() {
        return has_text_color;
    }

    public void setBoldPosition(String p) {
        bold_position = p;
    }

    public String getBoldPosition() {
        return bold_position;
    }

    public void setUnderlinedPosition(String p) {
        underlined_position = p;
    }

    public String getUnderlinedPosition() {
        return underlined_position;
    }

    public void setItalicsPosition(String p) {
        italics_position = p;
    }

    public String getItalicsPosition() {
        return italics_position;
    }

    public void setTextColorPosition(String p) {
        color_position = p;
    }

    public String getTextColorPosition() {
        return color_position;
    }
}
