package me.vicreaft.viryme.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.vicreaft.viryme.OsuReader;
import me.vicreaft.viryme.Viryme;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int temp;
    private SpriteBatch batch;
    private List<Column> columns = new ArrayList<Column>();
    private Texture texture;
    private Texture background;
    private Map map;
    private OsuReader osureader;
    public Game(int numberOfColumns, int columnLeftX, int columnWidth){
        batch = new SpriteBatch();
        //osureader = new OsuReader("/root/Desktop/Viryme/core/assets/game/eos/ginkiha - EOS -INFINITE EDIT- (MeowPaz) [Pharos' ADVANCED].osu");
        temp = 0;
        map = new Map();
        map.loadOsuFile("blabla");
        if(!(numberOfColumns >= 1)){
            System.out.println("One minimum column is needed to play");
        }else{

            Sound music = Gdx.audio.newSound(Gdx.files.internal("core/assets/game/eos/music.mp3"));
            music.play();

            this.background = new Texture(Gdx.files.internal("core/assets/game/eos/bg.jpg"));
            this.texture = new Texture(Gdx.files.internal("core/assets/game/note.png"));
            int width = texture.getWidth();
            float fHeight = ((float) columnWidth / (float) texture.getWidth()) * (float) texture.getHeight();
            columns.add(new Column(columnLeftX, 1000, columnWidth, (int) fHeight, 1, texture));

            for(int i = 1; i < numberOfColumns; i++) {
                columns.add(new Column(columnLeftX + columnWidth * i, 1000, columnWidth, (int) fHeight, i,texture));
            }

            for(int i = 0; i < columns.size(); i++){
                Viryme.fe.addListener(columns.get(i));
            }
        }


    }

    public void render(){

        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        //if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) column1.addNote();
        //if(Gdx.input.isKeyJustPressed(Input.Keys.D)) column2.addNote();

        columns.forEach((e) ->{
            e.render(1);
        });

        if(temp == 10){
            //System.out.println(Gdx.graphics.getFramesPerSecond());

            temp = 0;

            /*For this response of the map,
                [0] is the column number.
                [1] is the keytime.
             */
            int[] result = map.getNextNote();

            //Create the note following the Map's instructions
            columns.get(result[0]).addNote(result[1]);


            System.out.println(columns.get(0).notes.size() + columns.get(1).notes.size() + columns.get(2).notes.size() + columns.get(3).notes.size());
        }else{
            temp++;
        }

    }
}
