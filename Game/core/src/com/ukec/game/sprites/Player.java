package com.ukec.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Player {

    public static final Float GRAVITY = -9.81f;
    public static  Float speed = 250f;
    public static boolean onGround;

    private float width;

    private Vector3 position, velosity;

    public static Float getGRAVITY() {
        return GRAVITY;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    private Texture player;

    public Player(int x, int y, float width){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
        player = new Texture("player/hero.png");
        this.width = width;
        onGround = false;

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPlayer() {
        return player;
    }

    public static void setOnGround(boolean onGround) {
        Player.onGround = onGround;
    }

    public void update(float dt){
/// Gravity Force
        if (!onGround) {
            velosity.add(0, GRAVITY, 0);
            velosity.scl(dt);
            position.add(0, velosity.y, 0);

            velosity.scl(1 / dt);
        }
/// moving player
        if(Gdx.input.isTouched()){
            velosity.x = speed;
            velosity.scl(dt);

            byte direction;
            if(Gdx.input.getX() <= width/2) direction =-1;
            else direction = 1;
/// teleport start
            if (position.x < 0) {

                position.x = width;

            }

            if (position.x > width) {

                position.x = 0;

            }
/// teleport end
/// changing position player
            position.add(velosity.x * direction, 0, 0);

            velosity.scl(1/dt);
        }

    }

}
