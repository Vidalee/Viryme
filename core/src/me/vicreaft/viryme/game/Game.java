package me.vicreaft.viryme.game;


public class Game {

    private Column column;

    public Game(int columns){

    column = new Column();
    }

    public void render(){
        column.renderNote(1);
    }
}
