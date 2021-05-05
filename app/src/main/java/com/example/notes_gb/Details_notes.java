package com.example.notes_gb;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notes_gb.domain.Note;

import java.util.TimeZone;


public class Details_notes extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";

    public static Details_notes newInstance(Note note){

        Details_notes details_notes = new Details_notes();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE,note);

        details_notes.setArguments(bundle);

        return details_notes;
    }




    public Details_notes() {


        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nameNote = view.findViewById(R.id.name_note);

        TextView numberNote = view.findViewById(R.id.number_note);

        TextView content = view.findViewById(R.id.text_note);

        TextView dateAndTime = view.findViewById(R.id.date_note);

        Note note = getArguments().getParcelable(ARG_NOTE);

        nameNote.setText(note.getName());
        numberNote.setText("Заметка № "+note.getSerialNumber());
        content.setText(note.getContent());
        dateAndTime.setText(note.getDateTime());


    }
}