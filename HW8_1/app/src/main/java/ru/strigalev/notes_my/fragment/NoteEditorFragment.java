package ru.strigalev.notes_my.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.strigalev.notes_my.R;
import ru.strigalev.notes_my.data.Note;

public class NoteEditorFragment extends Fragment {

    private final static String EDITOR_KEY = "editor_key";

    private Button apply;
    private EditText title;
    private EditText body;
    private Note note;
    private NoteEditorFragmentListener noteEditorFragmentListener;

    public static NoteEditorFragment newInstance (Note note) {
        NoteEditorFragment fragment = new NoteEditorFragment();
        Bundle args = new Bundle();
        args.putParcelable(EDITOR_KEY, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(EDITOR_KEY);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        noteEditorFragmentListener = (NoteEditorFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_editor, container, false);

        initView(view);
        return  view;
    }
    private void initView (View view){
        apply = view.findViewById(R.id.button_apply_edit);
        title = view.findViewById(R.id.editTextTitle);
        body = view.findViewById(R.id.editTextBody);

        title.setText(note.getTitle());
        body.setText(note.getBody());
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note.setTitle(title.getText().toString());
                note.setBody(body.getText().toString());
                noteEditorFragmentListener.updateNote(note);
            }
        });
    }
}
