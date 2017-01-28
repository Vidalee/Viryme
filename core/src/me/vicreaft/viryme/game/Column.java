package me.vicreaft.viryme.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Column implements VirymeListener{

    private int columnNumber;
    private int x;
    private int columnHeight;
    private int noteWidth;
    private int noteHeight;
    private SpriteBatch batch;
    private Texture texture;
    public List<Note> notes = new ArrayList<Note>();
    List<Note> tempNotes = new ArrayList<>();

    private Iterator<Note> iterator = notes.iterator();



    public Column(int x, int columnHeight, int noteWidth, int noteHeight, int columnNumber, Texture texture) {
        this.columnNumber = columnNumber;
        this.x = x;
        this.columnHeight = columnHeight;
        this.noteWidth = noteWidth;
        this.noteHeight = noteHeight;
        this.noteHeight = noteHeight;
        this.texture = texture;
        batch = new SpriteBatch();

       // notes.add(new Note(x, columnHeight, noteWidth, noteHeight, 13, texture));

    }

    public void render(float delta) {

        batch.begin();

        /*
        I don't use a forEach() here since a note may be removed from the list, causing a ConcurrentModificationException.
        */
        notes.removeIf(e -> !e.active);
        notes.forEach((e) -> {
                e.update(delta);
                e.draw(batch);

        });

        batch.end();
    }

    public void addNote(int keyTime) {

        notes.add(new Note(x, 1336, noteWidth, noteHeight, keyTime, columnNumber, texture));

    }

    @Override
    public void onNoteDestruct(Note note, int column) {
        if(column == columnNumber) {
            //this.notes.remove(note);
            System.out.println("note détruite!");
        }
    }
}
