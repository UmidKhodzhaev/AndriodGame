package com.ukec.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Player {

    public static final Float GRAVITY = -9.81f;
    public static  Float speed = 250f;
    public static boolean onGround;
    public byte direction;

    private float width;

    private Integer hp;
    private Vector3 position, velosity;

    public static Float getGRAVITY() {
        return GRAVITY;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    private Texture player;

    private Texture heart;
    public Player(int x, int y, float width){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
        player = new Texture("player/zero.png");
        this.width = width;
        onGround = false;
        hp = 3;
        heart = new Texture("player/heart.png");
        direction = 0;

    }

    public Vector3 getPosition() {
        return position;
    }

    public Integer getHp() {
        return hp;
    }

    public Texture getPlayer() {
        return player;
    }

    public Texture getHeart()
    {
        return heart;
    }

    public static void setOnGround(boolean onGround) {
        Player.onGround = onGround;
    }

    public void update(float dt){
/// Gravity Force
        if (!onGround) {
            velosity.add(0, GRAVITY, 0);
            velosity.scl(dt);
            position.add(velosity.x, velosity.y, 0);

            velosity.scl(1 / dt);
        }
/// moving player
        if(Gdx.input.isTouched()){
            velosity.x = speed;
            velosity.scl(dt);
            if (position.x >= 0) {
                if(Gdx.input.getX() <= position.x){
                    direction =-1;
                }
            }
            if (position.x <= width - player.getWidth()){
                if(Gdx.input.getX() >= position.x + player.getWidth()){
                    direction = 1;
                }
            }


/// changing position player
            if (position.x <= width && position.x >= 0) {
                position.add(velosity.x * direction, 0, 0);
            }else{
                if(position.x < width/2)position.x+=5;
                else position.x -=5;
            }
            velosity.scl(1/dt);
        }

    }

    public boolean setDamage(boolean dmg){
        if (dmg){
            hp -= 1;
            dmg = false;
        }
        return dmg;
    }



}
