package com.ukec.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class Box  {

    public static final Float GRAVITY = -4.905f;
    public  boolean onGround;

    private Vector3 position, velosity;

    public static Float getGRAVITY() {
        return GRAVITY;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    private Texture box;
    private Float width;
    private Integer startY;

    public Box(int x, int y, float width){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
        box = new Texture("sprites/box/box_st.png");
        onGround = false;
        this.width = width;
        startY = y;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBox() {
        return box;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void update(float dt) {
/// Gravity Force
        if (!onGround) {
            velosity.add(0, GRAVITY, 0);
            velosity.scl(dt);
            position.add(0, velosity.y, 0);

            velosity.scl(1 / dt);
        }else{
            position.x = MathUtils.random(0, width-box.getWidth());
            position.y = startY;
            velosity.y = 0;
        }
    }

    public boolean checkCollide(Vector3 objPos, Texture objTexture ){
        boolean collided = false;
        if (position.y <= objPos.y + objTexture.getHeight()){
            if ((position.x >= objPos.x && position.x <= objPos.x + objTexture.getWidth()) || (position.x + box.getWidth()>= objPos.x && position.x + box.getWidth() <= objPos.x + objTexture.getWidth())){
                collided = true;
            }
        }

        return collided;
    }

}
