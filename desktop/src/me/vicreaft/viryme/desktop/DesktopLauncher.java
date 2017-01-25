package me.vicreaft.viryme.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.vicreaft.viryme.Viryme;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 768;
		config.width = 1336;
		/*Graphics.DisplayMode dm = LwjglApplicationConfiguration.getDesktopDisplayMode();
		config.setFromDisplayMode(dm);*/
		new LwjglApplication(new Viryme(), config);
	}
}
