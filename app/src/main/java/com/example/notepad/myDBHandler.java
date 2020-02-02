package com.example.notepad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notepadDB.db";

    public static final String COLUMN_ID = "_id";
    public static final String COLUNM_CONTENT = "content";
    public static final String COLUMN_HASBOLD = "has_bold";
    public static final String COLUMN_HASUNDERLINED = "has_underlined";
    public static final String COLUMN_HASITALICS = "has_italics";
    public static final String COLUMN_HASTEXTCOLOR = "has_text_color";
    public static final String COLUMN_BOLDPOSITION = "bold_position";
    public static final String COLUMN_UNDERLINEDPOSITION = "underlined_position";
    public static final String COLUMN_ITALICSPOSITION = "italics_position";
    public static final String COLUMN_COLORPOSITION = "color_position";

    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
