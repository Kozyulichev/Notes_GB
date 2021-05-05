package com.example.notes_gb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.notes_gb.domain.Note;

public class MainActivity extends AppCompatActivity implements Fragment_note.OnNoteClicked {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);


        if (!isLandscape) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            Fragment fragment = fragmentManager.findFragmentById(R.id.container);

            if (fragment == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ListFragment())
                        .commit();
            }

        }


    }

    @Override
    public void onNoteClicked(Note note) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (isLandscape) {
            fragmentManager.beginTransaction()
                    .replace(R.id.details_notes, Details_notes.newInstance(note))
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, Details_notes.newInstance(note))
                    .addToBackStack(null)
                    .commit();
        }
    }
}