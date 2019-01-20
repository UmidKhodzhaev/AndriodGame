package com.ukec.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ukec.game.MyGame;
import com.ukec.game.sprites.Player;

public class PlayState extends State {

    private Player player;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, MyGame.WIDTH/2, MyGame.HEIGHT/2);
        player = new Player(50, 240);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        player.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
