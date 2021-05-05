package com.example.notes_gb;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.notes_gb.domain.Note;
import com.example.notes_gb.domain.NotesRepo;

import java.util.List;


public class Fragment_note extends Fragment {

    public interface OnNoteClicked {
        void onNoteClicked(Note note);
    }

    private OnNoteClicked onNoteClicked;

    public Fragment_note() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnNoteClicked){
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteClicked = null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Note> notes = new NotesRepo().getNotes();

        LinearLayout noteList = view.findViewById(R.id.note_list);

        for (Note note : notes) {

            View noteView = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, noteList,
                    false);

            noteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openNoteDetail(note);
                }
            });

            TextView nameNote = noteView.findViewById(R.id.name_note);
            nameNote.setText(note.getName());

            TextView numberNote = noteView.findViewById(R.id.number_note);
            numberNote.setText("№" + note.getSerialNumber());

            TextView content = noteView.findViewById(R.id.text_note);
            content.setText(note.getContent());

            TextView dateAndTime = noteView.findViewById(R.id.date_note);
            dateAndTime.setText(note.getDateTime());

            noteList.addView(noteView);

        }


    }

    private void openNoteDetail(Note note) {

        if (onNoteClicked!=null){
            onNoteClicked.onNoteClicked(note);
        }
    }
}