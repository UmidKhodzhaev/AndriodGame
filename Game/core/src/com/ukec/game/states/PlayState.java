package com.ukec.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.ukec.game.MyGame;
import com.ukec.game.sprites.Blocks_1;
import com.ukec.game.sprites.Player;


public class PlayState extends State {

    private Player player;
    private Blocks_1 blocks;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);
        player = new Player(50, 240, MyGame.WIDTH);
        blocks = new Blocks_1(0, 0);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        player.update(dt);
        player.setOnGround(check());
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.draw(blocks.getBlock(), blocks.getPosition().x, blocks.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }

    private boolean check(){
        boolean onGround = false;
            if(player.getPosition().y <= blocks.getBlock().getHeight()){
                onGround = true;
                Vector3 position = new Vector3(player.getPosition().x, (blocks.getPosition().y + 96), 0);
                player.setPosition(position);
            }
        return onGround;
    }

}
