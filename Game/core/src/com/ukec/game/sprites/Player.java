package com.ukec.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Player {

    public static final Float GRAVITY = -9.81f;

    private Vector3 position, velosity;

    private Texture player;

    public Player(int x, int y){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
        player = new Texture("player/hero.png");

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPlayer() {
        return player;
    }

    public void update(float dt){
        velosity.add(0, GRAVITY, 0);
        velosity.scl(dt);
        position.add(0, velosity.y, 0);

        velosity.scl(1/dt);
    }

}
