package com.ukec.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.ukec.game.MyGame;

public class MenuState extends State {

    Texture background, startButton;

    Rectangle startBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("menu/menuBackground.png");
        startButton = new Texture("menu/startButton.png");
        startBtn = new Rectangle();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, MyGame.WIDTH, MyGame.HEIGHT);
        sb.draw(startButton, (MyGame.WIDTH/2 - startButton.getWidth()/2), (MyGame.HEIGHT/2 - startButton.getHeight()/2));
        sb.end();
    }

    @Override
    public void dispose() {
        startButton.dispose();
        background.dispose();
    }

}
