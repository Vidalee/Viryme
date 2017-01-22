package me.vicreaft.viryme.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private int x;
    private int y;
    private int noteWidth;
    private int noteHeight;
    private SpriteBatch batch;
    private Texture texture;
    public List<Note> notes = new ArrayList<Note>();


    public Column(int x, int y, int noteWidth, int noteHeight, Texture texture){
        this.x = x;
        this.y = y;
        this.noteWidth = noteWidth;
        this.noteHeight = noteHeight;
        this.texture = texture;
        batch = new SpriteBatch();

        notes.add(new Note(x, 1000, 256, 82, texture));

    }

    public void render(float delta){

        batch.begin();

        notes.forEach((e)->{
            e.update(delta);
            e.draw(batch);
        });

        batch.end();
    }

    public void addNote(){

        notes.add(new Note(x, 1000, noteWidth, noteHeight, texture));

    }
}
