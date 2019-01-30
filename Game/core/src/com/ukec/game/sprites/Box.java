package com.ukec.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Box  {

    public static final Float GRAVITY = -9.81f;
    public static boolean onGround;

    private Vector3 position, velosity;

    public static Float getGRAVITY() {
        return GRAVITY;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    private Texture box;

    public Box(int x, int y, float width){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
        box = new Texture("sprites/box/box_st.png");
        onGround = false;

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPlayer() {
        return box;
    }

    public static void setOnGround(boolean onGround) {
        Box.onGround = onGround;
    }

    public void update(float dt) {
/// Gravity Force
        if (!onGround) {
            velosity.add(0, GRAVITY, 0);
            velosity.scl(dt);
            position.add(0, velosity.y, 0);

            velosity.scl(1 / dt);
        }else{
            box.dispose();
        }
    }

}
