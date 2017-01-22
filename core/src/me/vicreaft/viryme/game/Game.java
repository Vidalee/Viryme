package me.vicreaft.viryme.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Column> columns = new ArrayList<Column>();
    private Texture texture;

    public Game(int numberOfColumns, int columnLeftX){

        if(!(numberOfColumns >= 1)){
            System.out.println("One minimum column is needed to play");
        }else{

            this.texture = new Texture(Gdx.files.internal("core/assets/game/barre.png"));
            int width = texture.getWidth();
            int height = texture.getHeight();

            columns.add(new Column(columnLeftX, 666, width, height, texture));

            for(int i = 1; i < numberOfColumns; i++) {
                columns.add(new Column(columnLeftX + width * i, 666, width, height, texture));
            }
        }


    }

    public void render(){

        //if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) column1.addNote();
        //if(Gdx.input.isKeyJustPressed(Input.Keys.D)) column2.addNote();

        columns.forEach((e) ->{
            e.render(1);
        });



    }
}
