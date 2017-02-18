package me.vicreaft.viryme.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.*;

public class Note {

    private Rectangle bound;
    private Texture texture;
    private int width;
    private int height;
    private float weight = 30; //La gravité ahah
    private int initialY;
    private int columnNumber;
    private int keyTime;
    private int hitLine = 0;
    private int fallingDirection;
    public boolean active = true;

    public Note(int x, int y, int width, int height, int keytime, int columnNumber, int fallingDirection, Texture texture){
        this.columnNumber = columnNumber;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.keyTime = keytime;
        this.fallingDirection = fallingDirection;
        bound = new Rectangle(x,y,width,height);
        initialY = y;


    }

    public void draw(SpriteBatch spriteBatch){
        //spriteBatch.draw(texture, bound.x, bound.y);

        spriteBatch.draw(texture, bound.x, bound.y, width, height);
    }

    public void update(float delta, float musicPosition){
        bound.y = hitLine - (int) ((((musicPosition * 1000) - keyTime)) * (weight / 20 * delta)) * fallingDirection;


        if(this.bound.y <= 0){
            destruct();
            //Viryme.fe.noteDestruct(this, columnNumber);
        }

        //if(this.bound.y <= 0) this.bound.y = initialY;


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

    public int getY() {
        return bound.y;
    }

    public int getKeyTime() {
        return keyTime;
    }
}
