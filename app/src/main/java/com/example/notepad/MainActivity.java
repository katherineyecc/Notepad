package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.notepad.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView editText = (TextView) findViewById(R.id.editText3);
    }

    public void enterNotepad(View view) {
        Intent intent = new Intent(this, openNote.class);
        startActivity(intent);
    }
}

