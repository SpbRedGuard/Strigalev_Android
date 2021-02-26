package ru.strigalev.notes_my.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import ru.strigalev.notes_my.R;
import ru.strigalev.notes_my.data.Note;

public class NoteListFragment extends Fragment {

    //Ключ аргумента в Bundle args
    private final static String NOTE_KEY = "note_key";

    private List<Note> noteList;
    private RecyclerView recyclerView;
    private NoteListAdapter noteListAdapter;
    private CreateFragment createFragment;
    private NoteListAdapter adapter;

    // Фрагмент самоинииализируется, передавая  значение notelist в Bundle. Фабричное создание метода
    public static NoteListFragment newInstance(ArrayList<Note> notelist) {
        NoteListFragment fragment = new NoteListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(NOTE_KEY, notelist);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //если значение не null, то получаем notelist из Bundle
        if (getArguments() != null) {
            noteList = getArguments().getParcelableArrayList(NOTE_KEY);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createFragment = (CreateFragment) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView (View view) {
    recyclerView = view.findViewById(R.id.recycler_note);
    recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteListAdapter(noteList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener (new ItemClickListener() {
            @Override
            public void itemClick(int position) {
                createFragment.startEditorFragment(position);
            }
        });
    }
    public void upDateAdapterPosition (int position) {
        adapter.notifyItemChanged(position);
    }
}
