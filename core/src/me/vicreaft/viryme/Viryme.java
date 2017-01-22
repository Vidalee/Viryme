package me.vicreaft.viryme;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import me.vicreaft.viryme.game.Game;

public class Viryme implements ApplicationListener {
	private Game game;

	@Override
	public void create() {


		game = new Game(4, 300, 300);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
		game.render();


    }

	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}