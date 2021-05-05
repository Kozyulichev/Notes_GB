package com.example.notes_gb.domain;

import java.util.ArrayList;
import java.util.List;

public class NotesRepo {

    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("Рецепт ужина","Макароны 400г, бекон 300г"));
        notes.add(new Note("Список дел","Заказать наличники, опломбировать счетчики"));
        notes.add(new Note("Учеба","Понять как вся эта срань работает"));
        notes.add(new Note("Женщина","Отвезти за новым платьем на выходных"));

        return notes;
    }
}
