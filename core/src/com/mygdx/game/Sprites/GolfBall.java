package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;

import javax.swing.text.TabExpander;

/**
 * Created by andrewgingerich on 12/9/16.
 */
public class GolfBall {
    private Vector3 position;
    private Vector3 velocity;
    private Texture golfBall;
    private int FRICTION;

    public GolfBall(float x, float y) {
        FRICTION = 0;
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        golfBall = new Texture("golfBall.png");
    }

    public void update(float dt){
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);
        velocity.scl(1/dt);
        velocity.add(0, 0, 0);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getGolfBall() {
        return golfBall;
    }

    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }
}
