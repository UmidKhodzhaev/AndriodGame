package com.ukec.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ukec.game.states.GameStateManager;
import com.ukec.game.states.MenuState;

public class MyGame extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;


	public static final String TITLE = "Simple Game";

	private GameStateManager gsm;
	private SpriteBatch batch;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
