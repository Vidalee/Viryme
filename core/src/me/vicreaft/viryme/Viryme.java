package me.vicreaft.viryme;



import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import me.vicreaft.viryme.game.FireEvents;
import me.vicreaft.viryme.game.Game;

public class Viryme implements ApplicationListener {
    public static FireEvents fe;
	private Game game;
	private FPSLogger fps;
	@Override
	public void create() {
	    fe = new FireEvents();

        //Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		game = new Game(4, 300, 200, 1);
		fps = new FPSLogger();

	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {

        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
		game.render();
		//System.out.println(Gdx.graphics.getFramesPerSecond());

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