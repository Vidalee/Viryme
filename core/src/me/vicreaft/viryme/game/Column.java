package me.vicreaft.viryme.game;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Column {

    private SpriteBatch batch;
    private Note note;

    public Column(){
        batch = new SpriteBatch();
        note = new Note(300, 600, 256, 82);

    }

    public void renderNote(float delta){
        note.update(delta);

        batch.begin();
        note.draw(batch);
        batch.end();
    }
}
