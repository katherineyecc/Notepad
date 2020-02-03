package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class openNote extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<noteItem> mData = null;
    private Context mContext;
    private noteItemAdapter mAdapter = null;
    private ListView list_note;

    public static final String NOTE_ID = "com.example.notepad.openNote.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_note);
        mContext = openNote.this;
        list_note = (ListView) findViewById(R.id.list_note);
        mData = new LinkedList<noteItem>();

        // Get note item list from database;
        myDBHandler dbHandler = new myDBHandler(this, null, null,1);
        mData = dbHandler.getAllNoteItem();

        mAdapter = new noteItemAdapter((LinkedList<noteItem>) mData, mContext);
        list_note.setAdapter(mAdapter);
        list_note.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Set the action when click on the item
        // The action is entering a new note activity
        // ...
        TextView tv = (TextView) view.findViewById(R.id.note_id);
        String clickedID = tv.getText().toString();
        Intent intent = new Intent(this, EditNoteActivity.class);
        intent.putExtra(NOTE_ID, clickedID);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.new_note:
                createNewNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createNewNote() {
        Intent intent = new Intent(this, EditNoteActivity.class);
        startActivity(intent);
    }
}
