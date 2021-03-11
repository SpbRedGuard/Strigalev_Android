package ru.strigalev.notes_my.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.List;
import ru.strigalev.notes_my.R;
import ru.strigalev.notes_my.data.Note;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder>  {
    private List<Note> noteList;
    private ItemClickListener itemClickListener;

    public NoteListAdapter (List<Note> noteList){
        this.noteList = noteList;
    }

    //Setter слушателя нажатий
    public void setOnItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public NoteListAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder (@NonNull NoteListAdapter.ViewHolder holder, int position) {
        holder.bind(noteList.get(position));
    }
    @Override
    public int getItemCount(){
        return noteList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView body;
        private TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_note_textView_title);
            body = itemView.findViewById(R.id.item_note_textView_body);
            date = itemView.findViewById(R.id.item_note_textView_date);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemClickListener != null && getAdapterPosition() != -1) {
                            itemClickListener.itemClick(getAdapterPosition());
                        }
                    }
                });
        }
        public void bind (Note note) {
            title.setText(note.getTitle());
            body.setText(note.getBody());
            date.setText(new SimpleDateFormat("dd-MM-yy").format(note.getDate()));
        }
    }
}
