package me.vicreaft.viryme.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Note {

    private Rectangle bound;
    private Texture texture;
    private float weight = 15; //La gravité ahah
    private int initalY;

    public Note(int x, int y, int width, int height){
        texture = new Texture(Gdx.files.internal("core/assets/game/note.png"));
        bound = new Rectangle(x,y,width,height);
        initalY = y;

    }

    public void draw(SpriteBatch spriteBatch){
        if(this.bound.y <= 0) this.bound.y = initalY;
        spriteBatch.draw(texture, bound.x, bound.y);
    }

    public void update(float delta){
        bound.y -= weight*delta;
    }

    public Rectangle getBound(){
        return bound;
    }

    public Texture getTexture(){
        return texture;
    }


}
