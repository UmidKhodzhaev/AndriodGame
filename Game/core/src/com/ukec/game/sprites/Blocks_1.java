package com.ukec.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Blocks_1 {

    private Texture block;

    private Vector3 position;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBlock() {
        return block;
    }

    public Blocks_1(int x, int y){
        block = new Texture("sprites/blocks/Block_1(R2L).png");

        position = new Vector3(x, y, 0);
    }


}
