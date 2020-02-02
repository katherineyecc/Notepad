package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditNoteActivity extends AppCompatActivity {

    private TextView editNoteID;
    private EditText editNoteTitle;
    private EditText editNoteContent;
    private Note note = new Note();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editNoteID = (TextView) findViewById(R.id.edit_note_id);
        editNoteTitle = (EditText) findViewById(R.id.edit_note_title);
        editNoteContent = (EditText) findViewById(R.id.edit_note_content);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = null;
        message1 = intent.getStringExtra(openNote.NOTE_ID);
        // If message1 == null, then it is not transferred from openNote
        // which means the user is creating a new note

        myDBHandler dbHandler = new myDBHandler(this, null, null,1);
        if(message1 != null) {
            // CASE 1: user is re-editing an existing note
            // ...
            note = dbHandler.findNote(Integer.parseInt(message1));
            setContent(note);
        }

        // CASE 2: user is creating and editing a new note
        // ...


    }

    public void setContent(Note note) {
        editNoteID.setText(Integer.toString(note.getID()));
        editNoteTitle.setText(note.getTitle());
        editNoteContent.setText(note.getContent());
    }

    public void saveNote(View view) {
        // When user click on the SAVE button
        // the function transfer the note info to the database,
        // and jump to the DisplayNotepad.xml
        myDBHandler dbHandler = new myDBHandler(this, null, null,1);
        note.setTitle(editNoteTitle.getText().toString());
        note.setContent(editNoteContent.getText().toString());
        // Other attributes to implement ...
        dbHandler.addNote(note);
    }
}
