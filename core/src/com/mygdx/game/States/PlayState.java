package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.*;
import com.mygdx.game.Sprites.GolfBall;
import com.mygdx.game.Sprites.Golfer;



/**
 * Created by andrewgingerich on 12/8/16.
 */

public class PlayState extends State{
    private Golfer golfer;
    private GolfBall golfBall;
    private Rectangle golferBounds;
    private Circle golfBallBounds;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        golfer = new Golfer(50,50);
        golfBall = new GolfBall(golfer.getPosition().x, 200);
        MyInputProcessor inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
        golferBounds = new Rectangle(golfer.getPosition().x, golfer.getPosition().y,golfer.getGolfer().getWidth(),golfer.getGolfer().getHeight());
        golfBallBounds = new Circle(golfBall.getPosition().x,golfBall.getPosition().y, 40);
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {
        golfer.update(dt);
        golfBall.update(dt);
        golferBounds.setPosition(golfer.getPosition().x,golfer.getPosition().y);
        golfBallBounds.setPosition(golfBall.getPosition().x,golfBall.getPosition().y);
        if(Intersector.overlaps(golfBallBounds, golferBounds)){
            System.out.println("Colliding");
        }
    }

    public class MyInputProcessor implements InputProcessor {
        public boolean keyDown(int keycode) {
            if (keycode == Input.Keys.A) {
                golfer.beginMovement("left");
            }
            if (keycode == Input.Keys.D) {
                golfer.beginMovement("right");
            }
            if (keycode == Input.Keys.W) {
                golfer.beginMovement("up");
            }
            if (keycode == Input.Keys.S) {
                golfer.beginMovement("down");
            }
            return true;
        }

        public boolean keyUp(int keycode) {
            if (keycode == Input.Keys.A) {
                golfer.stopMovement("left");
            }
            if (keycode == Input.Keys.D) {
                golfer.stopMovement("right");
            }
            if (keycode == Input.Keys.W) {
                golfer.stopMovement("up");
            }
            if (keycode == Input.Keys.S) {
                golfer.stopMovement("down");
            }
            return true;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            return true;
        }
        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return true;
        }
        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return true;
        }
        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }
        @Override
        public boolean scrolled(int amount) {
            return false;
        }
    }
        @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(golfBall.getGolfBall(), golfBall.getPosition().x,golfBall.getPosition().y);
        sb.draw(golfer.getGolfer(), golfer.getPosition().x, golfer.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
