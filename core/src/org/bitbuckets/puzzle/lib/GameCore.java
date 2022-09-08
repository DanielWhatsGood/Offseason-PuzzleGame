package org.bitbuckets.puzzle.lib;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.bitbuckets.puzzle.PuzzleGameSolution;
import org.bitbuckets.puzzle.lib.impl.GraphicsSystem;

/**
 * Loads the graphics system and the game solution
 * Don't modify this file unless you know what you are doing
 */
public class GameCore implements ApplicationListener  {

    SpriteBatch batch;
    GraphicsSystem system;
    SubSystem solution;

    @Override
    public void create() {

        //make a graphics batcher
        batch = new SpriteBatch();

        int screenWidthPx = Gdx.graphics.getWidth();
        int screenHeightPx = Gdx.graphics.getHeight();

        int squareWidthPx = screenWidthPx / 10;
        int squareHeightPx = screenHeightPx / 10;

        Sprite[] sprites = new Sprite[5];
        sprites[0] = new Sprite(new Texture("box.png"));
        sprites[1] = new Sprite(new Texture("floor.png"));
        sprites[2] = new Sprite(new Texture("player.png"));
        sprites[3] = new Sprite(new Texture("target.png"));
        sprites[4] = new Sprite(new Texture("wall.png"));

        system = new GraphicsSystem(squareWidthPx, squareHeightPx, sprites); //set up a graphics system
        solution = new PuzzleGameSolution();

        solution.init();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        solution.periodic(system);

        batch.begin();
        //batch.draw(region,0,0);
        system.draw(batch);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
