package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class MenuScreen extends AbstractGameScreen{
    private static final String TAG = MenuScreen.class.getName();
    public MenuScreen (Game game) {
        super(game);
    }
    @Override
    public void render (float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isTouched())
            game.setScreen(new GameScreen(game));
    }
    @Override public void resize (int width, int height) { }
    @Override public void show () { }
    @Override public void hide () { }
    @Override public void pause () { }
}
