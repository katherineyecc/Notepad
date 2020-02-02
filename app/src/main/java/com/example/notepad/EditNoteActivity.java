package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class EditNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(openNote.NOTE_ID);
        // If message1 == null, then it is not transferred from openNote
        // which means the user is creating a new note

        // CASE 1: user is re-editing an existing note
        // ...


        // CASE 2: user is creating and editing a new note
        // ...
    }
}
