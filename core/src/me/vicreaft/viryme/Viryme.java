package me.vicreaft.viryme;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.vicreaft.viryme.game.Note;

public class Viryme implements ApplicationListener {
	private SpriteBatch batch;
	private BitmapFont font;
	private Note note;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		note = new Note(300, 600, 256, 82);
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	@Override
	public void render() {
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
		renderNote(1);


    }

	public void renderNote(float delta){
		note.update(delta);

		batch.begin();
		note.draw(batch);
		batch.end();
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