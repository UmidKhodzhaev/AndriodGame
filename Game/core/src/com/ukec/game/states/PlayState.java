package com.ukec.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.ukec.game.MyGame;
import com.ukec.game.sprites.Blocks_1;
import com.ukec.game.sprites.Box;
import com.ukec.game.sprites.Player;


public class PlayState extends State {

    private Player player;
    private Blocks_1 blocks;
    private Box firstBox;
    private Box secondBox;
    private Box thirdBox;

    private Long startTime = TimeUtils.millis();


    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);
        player = new Player(1, 240, MyGame.WIDTH);
        blocks = new Blocks_1(0, 0);
        firstBox = new Box(MathUtils.random(0, MyGame.WIDTH), MyGame.HEIGHT, MyGame.WIDTH);
        secondBox = new Box(MathUtils.random(0, MyGame.WIDTH), MyGame.HEIGHT, MyGame.WIDTH);
        thirdBox = new Box(MathUtils.random(0, MyGame.WIDTH), MyGame.HEIGHT, MyGame.WIDTH);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        player.update(dt);
        boxes(dt);
        player.setOnGround(checkPlayer());
        Box.setOnGround(checkBox(firstBox));
        Box.setOnGround(checkBox(secondBox));
        Box.setOnGround(checkBox(thirdBox));
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.draw(blocks.getBlock(), blocks.getPosition().x, blocks.getPosition().y);
        sb.draw(firstBox.getBox(), firstBox.getPosition().x, firstBox.getPosition().y);
        sb.draw(secondBox.getBox(), secondBox.getPosition().x, firstBox.getPosition().y);
        sb.draw(thirdBox.getBox(), thirdBox.getPosition().x, firstBox.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }

    private boolean checkPlayer(){
        boolean onGround = false;
            if(player.getPosition().y <= blocks.getBlock().getHeight()){
                onGround = true;
                Vector3 position = new Vector3(player.getPosition().x, (blocks.getPosition().y + 96), 0);
                player.setPosition(position);
            }
        return onGround;
    }
    private boolean checkBox(Box box){
        boolean onGround = false;
            if(box.getPosition().y <= blocks.getBlock().getHeight()){
                onGround = true;
                Vector3 position = new Vector3(box.getPosition().x, (blocks.getPosition().y + 96), 0);
                box.setPosition(position);
            }
        return onGround;
    }

    private void boxes(float dt){
        firstBox.update(dt);

        secondBox.update(dt);

        thirdBox.update(dt);
    }

}
