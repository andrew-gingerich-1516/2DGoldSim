package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by andrewgingerich on 12/9/16.
 */
public class Golfer {
    private Vector3 position;
    private Vector3 velocity;
    private Texture golfer;

    public Golfer(float x, float y) {
        position = new Vector3(0,0,0);
        velocity = new Vector3(x,y,0);
        golfer = new Texture("golfer.png");

    }

    public void update(float dt){
        velocity.add(0, 0, 0);
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);
        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public Texture getGolfer() {
        return golfer;
    }
}
