package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.screens.MenuScreen;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class TileMapMain extends Game {
    private static final String TAG = TileMapMain.class.getName();
    private boolean paused;
    private WorldController worldController;
    private WorldRenderer worldRenderer;

    @Override
    public void create(){
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        setScreen(new MenuScreen(this));
    }


}
