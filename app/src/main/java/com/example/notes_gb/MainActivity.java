package com.example.notes_gb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.notes_gb.domain.Note;

public class MainActivity extends AppCompatActivity implements Fragment_note.OnNoteClicked {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity();


    }

    public void startActivity() {
        initToolBar();
        initView();


    }

    private void initToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Заметки");
        setSupportActionBar(toolbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchText = (SearchView) search.getActionView();
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                return true;
            case R.id.actions_add:
                Toast.makeText(MainActivity.this,"Добавить заметку",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_about:
                Toast.makeText(MainActivity.this,"О приложении",Toast.LENGTH_LONG).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    public void initView() {
        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);


        if (!isLandscape) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            Fragment fragment = fragmentManager.findFragmentById(R.id.container);

            if (fragment == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new Fragment_note())
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