package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Sprites.GolfBall;
import com.mygdx.game.Sprites.Golfer;

/**
 * Created by andrewgingerich on 12/8/16.
 */
public class PlayState extends State{
    private Texture background;
    private Golfer golfer;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        background= new Texture("badlogic.jpg");
        golfer = new Golfer(0,0);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        golfer.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(golfer.getGolfer(), 0,0);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
