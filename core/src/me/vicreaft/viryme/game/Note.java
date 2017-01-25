package me.vicreaft.viryme.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.vicreaft.viryme.Viryme;

import java.awt.*;

public class Note {

    private Rectangle bound;
    private Texture texture;
    private int width;
    private int height;
    private float weight = 15; //La gravité ahah
    private int initialY;
    private int columnNumber;
    private int keyTime;
    public boolean active = true;

    public Note(int x, int y, int width, int height, int keytime, int columnNumber, Texture texture){
        this.columnNumber = columnNumber;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.keyTime = keytime;
        bound = new Rectangle(x,y,width,height);
        initialY = y;

    }

    public void draw(SpriteBatch spriteBatch){
        //spriteBatch.draw(texture, bound.x, bound.y);

        spriteBatch.draw(texture, bound.x, bound.y, width, height);
    }

    public void update(float delta){

        //if(this.bound.y <= 0) this.bound.y = initialY;
        if(this.bound.y <= 0 && this.bound.y > -20){
            destruct();
            //Viryme.fe.noteDestruct(this, columnNumber);
        }

        bound.y -= weight*delta;
    }

    private void destruct(){
        //this.texture.dispose();
        active = false;
    }

    public Rectangle getBound(){
        return bound;
    }

    public Texture getTexture(){
        return texture;
    }


}
