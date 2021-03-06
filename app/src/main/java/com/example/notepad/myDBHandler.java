package com.example.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class myDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notepadDB.db";
    private static final String TABLE_NOTEPAD = "notepad";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_TITLE = "title";
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
        System.out.println("Enter the onCreate function!");
        String CREATE_TABLE = "create table " + TABLE_NOTEPAD +
                "(" + COLUMN_ID + " integer primary key," +
                COLUMN_TITLE + " text," +
                COLUMN_CONTENT + " text," + COLUMN_HASBOLD + " boolean," +
                COLUMN_HASUNDERLINED + " boolean," +
                COLUMN_HASITALICS + " boolean," +
                COLUMN_HASTEXTCOLOR + " boolean," +
                COLUMN_BOLDPOSITION + " text," +
                COLUMN_UNDERLINEDPOSITION + " text," +
                COLUMN_ITALICSPOSITION + " text," +
                COLUMN_COLORPOSITION + " text" + ");";
        db.execSQL(CREATE_TABLE);
        System.out.println("Table is created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NOTEPAD);
        onCreate(db);
    }

    public void addNote(Note note) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_CONTENT, note.getContent());
        values.put(COLUMN_HASBOLD, note.getHasBold());
        values.put(COLUMN_HASUNDERLINED, note.getHasUnderlined());
        values.put(COLUMN_HASITALICS, note.getHasItalics());
        values.put(COLUMN_HASTEXTCOLOR, note.getHasTextColor());
        values.put(COLUMN_BOLDPOSITION, note.getBoldPosition());
        values.put(COLUMN_UNDERLINEDPOSITION, note.getUnderlinedPosition());
        values.put(COLUMN_ITALICSPOSITION, note.getItalicsPosition());
        values.put(COLUMN_COLORPOSITION, note.getTextColorPosition());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NOTEPAD, null, values);
        db.close();
    }

    public boolean deleteNote(int noteID) {
        boolean result = false;
        String ID = Integer.toString(noteID);

        String query = "select * from " + TABLE_NOTEPAD +
                " where " + COLUMN_ID + " = " + ID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Note note = new Note();
        if(cursor.moveToFirst()) {
            note.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NOTEPAD, COLUMN_ID + " = ?",
                    new String[] {String.valueOf(note.getID())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public Note findNote(int noteID) {
        String ID = Integer.toString(noteID);
        String query = "select * from " + TABLE_NOTEPAD +
                " where " + COLUMN_ID + " = " + ID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Note note = new Note();
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            note.setID(Integer.parseInt(cursor.getString(0)));
            note.setTitle(cursor.getString(1));
            note.setContent(cursor.getString(2));
            note.setHasBold(Boolean.getBoolean(cursor.getString(3)));
            note.setHasUnderlined((Boolean.getBoolean(cursor.getString(4))));
            note.setHasitalics(Boolean.getBoolean(cursor.getString(5)));
            note.setHasTextColor(Boolean.getBoolean(cursor.getString(6)));
            note.setBoldPosition(cursor.getString(7));
            note.setUnderlinedPosition(cursor.getString(8));
            note.setItalicsPosition(cursor.getString(9));
            note.setTextColorPosition(cursor.getString(10));
            cursor.close();
        } else {
            note = null;
        }
        db.close();
        return note;
    }

    public LinkedList<noteItem> getAllNoteItem() {
        String query = "select " + COLUMN_ID + " , " + COLUMN_TITLE +
                " from " + TABLE_NOTEPAD;
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println("DATABASE PATH: " + db.getPath());
        Cursor cursor = db.rawQuery(query, null);
        LinkedList<noteItem> items = new LinkedList<>();
        noteItem item = new noteItem();
        int row = 0;
        while(row < cursor.getCount()) {
            item.setID(Integer.parseInt(cursor.getString(0)));
            item.setTitle(cursor.getString(1));
            row++;
            items.add(item);
        }
        cursor.close();
        db.close();
        return items;
    }
}
