package com.mygdx.game.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.mygdx.game.game.objects.Objects.BlueMan;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class Level {
    public static final String TAG = Level.class.getName();

    IsometricTiledMapRenderer tiledMapRenderer;
    TiledMap tiledMap;
    BlueMan blueMan;

    private void init (String filename) {
        //initialize blue man here
        blueMan = null;
        //initialize tile map here not in world renderer
    }

    public void render (SpriteBatch batch){
        blueMan.render(batch);
        //need to render tilemap here
    }
}
