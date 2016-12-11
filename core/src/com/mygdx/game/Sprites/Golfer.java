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
    public String directionX;
    public String directionY;

    public Golfer(float x, float y) {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        golfer = new Texture("golfer.png");

    }

    public void update(float dt){
        velocity.add(0, 0, 0);
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);
        velocity.scl(1/dt);

        if(velocity.x < -199){
            directionX = "left";
        }
        else if(velocity.x > 199){
            directionX = "right";
        }
        else{
            directionX = "";
        }
        if(directionX == "" && velocity.y < -199){
            directionY = "down";
        }
        else if(directionX == "" && velocity.y > 199){
            directionY = "up";
        }
        else{
            directionY = "";
        }

        if(velocity.x == 0 && velocity.y == 0){
            directionX = "";
            directionY = "";
        }
    }
    public void beginMovement(String direction){
        if(direction == "up"){
            velocity.y = velocity.y + 200;
        }
        if(direction == "down"){
            velocity.y = velocity.y - 200;
        }
        if(direction == "right"){
            velocity.x = velocity.x + 200;
        }
        if(direction == "left"){
            velocity.x = velocity.x - 200;
        }
    }
    public void stopMovement(String direction){
        if(direction == "up"){
            velocity.y = velocity.y - 200;
        }
        if(direction == "down"){
            velocity.y = velocity.y + 200;
        }
        if(direction == "left"){
            velocity.x = velocity.x + 200;
        }
        if(direction=="right"){
            velocity.x = velocity.x - 200;
        }
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getGolfer() {
        return golfer;
    }
}
