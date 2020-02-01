package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class DisplayNotepad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notepad);
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
            case R.id.open_saved_note:
                openSavedNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createNewNote() {
        Intent intent = new Intent(this, createNote.class);
        startActivity(intent);
    }

    public void openSavedNote() {
        Intent intent = new Intent(this, openNote.class);
        startActivity(intent);
    }
}
