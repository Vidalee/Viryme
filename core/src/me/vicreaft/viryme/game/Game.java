package me.vicreaft.viryme.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.vicreaft.viryme.Viryme;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int temp;
    private SpriteBatch batch;
    private List<Column> columns = new ArrayList<>();
    private Texture texture;
    private Texture background;
    private Map map;
    private int numberOfNotesRendered;
    private int fallingDirection;
    private Music music;
    private float musicPosition = 0;

    public Game(int numberOfColumns, int columnLeftX, int columnWidth, int fallingDirection){
        this.fallingDirection = fallingDirection;
        numberOfNotesRendered = 0;
        batch = new SpriteBatch();
        temp = 0;
        map = new Map();
        map.loadOsuFile("blabla");
        if(numberOfColumns < 1){
            System.out.println("One minimum column is needed to play");
        }else{

            music = Gdx.audio.newMusic(Gdx.files.internal("core/assets/game/eos/music.mp3"));
            music.play();

            this.background = new Texture(Gdx.files.internal("core/assets/game/eos/bg.jpg"));
            this.texture = new Texture(Gdx.files.internal("core/assets/game/note.png"));
            int width = texture.getWidth();
            float fHeight = ((float) columnWidth / (float) texture.getWidth()) * (float) texture.getHeight();
            columns.add(new Column(columnLeftX, 1000, columnWidth, (int) fHeight, 1, fallingDirection, texture));

            for(int i = 1; i < numberOfColumns; i++) {
                columns.add(new Column(columnLeftX + columnWidth * i, 1000, columnWidth, (int) fHeight, i, fallingDirection, texture));
            }

            columns.forEach((e) -> Viryme.fe.addListener(e));

        }


    }

    public void render() {
        musicPosition = music.getPosition();
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        //if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) column1.addNote();
        //if(Gdx.input.isKeyJustPressed(Input.Keys.D)) column2.addNote();

        columns.forEach((e) -> {
            e.render(1, musicPosition);
        });

        if (temp == 5) {

            temp = 0;

            /*For this response of the map,
                [0] is the column number.
                [1] is the keytime.
             */
            int[] result = map.getNextNote();

            //If result [0] = -1; then we reached the maximum of note. It should not happen, but it's a security to not make the game crash.


            if (result[0] != -1) {
                //Create the note following the Map's instructions
                columns.get(result[0]).addNote(result[1]);


            }
            numberOfNotesRendered = columns.get(0).notes.size() + columns.get(1).notes.size() + columns.get(2).notes.size() + columns.get(3).notes.size();

            System.out.println("Notes rendered atm : " + numberOfNotesRendered + " | FPS: " + Gdx.graphics.getFramesPerSecond());

        } else {
                temp++;


    }

    }
}
