package ru.strigalev.notes_my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Calendar;
import ru.strigalev.notes_my.data.Note;
import ru.strigalev.notes_my.fragment.CreateFragment;
import ru.strigalev.notes_my.fragment.NoteEditorFragment;
import ru.strigalev.notes_my.fragment.NoteEditorFragmentListener;
import ru.strigalev.notes_my.fragment.NoteListFragment;

public class MainActivity extends AppCompatActivity implements CreateFragment, NoteEditorFragmentListener {

    private ArrayList<Note> noteList;
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
        // имитируем данные
        noteList = new ArrayList<>();
        noteList.add(new Note(0, getString(R.string.title_one), getString(R.string.body_1), Calendar.getInstance().getTime()));
        noteList.add(new Note(1, getString(R.string.title_two), getString(R.string.body_2), Calendar.getInstance().getTime()));
        noteList.add(new Note(2, getString(R.string.title_three), getString(R.string.body_3), Calendar.getInstance().getTime()));
          }

    private void initStartFragment() {
        noteListFragment = NoteListFragment.newInstance(noteList);
        navigation = new Navigation(getSupportFragmentManager());
        navigation.addFragment(noteListFragment, false);
    }
    @Override
    public void startEditorFragment(int position) {
        noteEditorFragment = NoteEditorFragment.newInstance(noteList.get(position));
        navigation.addFragment(noteEditorFragment, true);
    }
    @Override
    public void updateNote (Note note) {
        int position = note.getId();
        noteList.remove(position);
        noteList.add(position, note);
        noteListFragment.upDateAdapterPosition(position);
        navigation.removeFragment();
    }

}