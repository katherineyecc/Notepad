package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.LinkedList;
import java.util.List;

public class openNote extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<noteItem> mData = null;
    private Context mContext;
    private noteItemAdapter mAdapter = null;
    private ListView list_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_note);
        mContext = openNote.this;
        list_note = (ListView) findViewById(R.id.list_note);
        mData = new LinkedList<noteItem>();
        // Get id and title from database
        // and reform them into noteItem
        // Add all saved item into mData, using
        // mData.add(int i, noteItem e);
        mAdapter = new noteItemAdapter((LinkedList<noteItem>) mData, mContext);
        list_note.setAdapter(mAdapter);
        list_note.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Set the action when click on the item
        // The action is entering a new note activity
        // ...
    }
}
