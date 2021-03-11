package ru.strigalev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private ArrayList<Note> notelist;
        private Navigation navigation;
        private NoteEditorFragment noteEditorFragment;
        private NoteListFragment noteListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNoteList();
        initStartFragment();
    }
    private void initNoteList(){
        // имитируем получение данных в приложение
        notelist = new ArrayList<>();

    }
}