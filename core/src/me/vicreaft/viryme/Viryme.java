package me.vicreaft.viryme;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.vicreaft.viryme.game.Game;
import me.vicreaft.viryme.game.Note;

public class Viryme implements ApplicationListener {
	private SpriteBatch batch;
	private BitmapFont font;
	private Note note;
	private Game game;

	@Override
	public void create() {
		game = new Game(1);
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
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