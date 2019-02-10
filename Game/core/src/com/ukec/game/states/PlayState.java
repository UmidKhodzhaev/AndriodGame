package com.ukec.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.ukec.game.MyGame;
import com.ukec.game.sprites.Blocks_1;
import com.ukec.game.sprites.Box;
import com.ukec.game.sprites.Player;


public class PlayState extends State {

    BitmapFont bf;

    private Player player;
    private Blocks_1 blocks;
    private Box firstBox;

    private Long startTime = TimeUtils.millis();
    private boolean damaged;
    private Integer maxHp;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);
        player = new Player(1, 240, MyGame.WIDTH);
        blocks = new Blocks_1(0, 0);
        firstBox = new Box(MathUtils.random(0, MyGame.WIDTH), MyGame.HEIGHT, MyGame.WIDTH);
        bf = new BitmapFont();
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        player.setOnGround(checkPlayer());
        firstBox.setOnGround(checkBox(firstBox));
        player.setDamage(damaged);
        if (player.getHp() <= 0) {
            gsm.set(new MenuState(gsm));
        }
        player.update(dt);
        boxes(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        String strHp = "HP:" + player.getHp();

        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        bf.draw(sb, strHp, 10, 460);
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.draw(blocks.getBlock(), blocks.getPosition().x, blocks.getPosition().y);
        hpDraw(sb);
        sb.draw(firstBox.getBox(), firstBox.getPosition().x, firstBox.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }

    private boolean checkPlayer() {
        boolean onGround = false;
        if (player.getPosition().y <= blocks.getBlock().getHeight()) {
            onGround = true;
            Vector3 position = new Vector3(player.getPosition().x, (blocks.getPosition().y + 96), 0);
            player.setPosition(position);
        }
        return onGround;
    }

    private boolean checkBox(Box box) {
        boolean collided = false;

        if (box.checkCollide(blocks.getPosition(), blocks.getBlock())) {
            collided = true;
        }

        if (box.checkCollide(player.getPosition(), player.getPlayer())) {
            collided = true;
            Vector3 position = new Vector3(box.getPosition().x, (blocks.getPosition().y + 96), 0);
            box.setPosition(position);
            this.damaged = true;
        }
        return collided;
    }

    private void boxes(float dt) {
        firstBox.update(dt);
    }

    private void hpDraw(SpriteBatch sb) {
        for (int i = 0; i < player.getHp(); i++) {
            int x = player.getHeart().getWidth() * 3 / 2;
            int y = MyGame.HEIGHT - player.getHeart().getHeight() * 3;
            sb.draw(player.getHeart(), x * i, y);
        }
    }

}
