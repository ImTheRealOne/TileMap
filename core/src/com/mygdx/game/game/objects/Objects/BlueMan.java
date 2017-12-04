package com.mygdx.game.game.objects.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class BlueMan extends  AbstractGameObject{
    public static  final String TAG = BlueMan.class.getName();

    public enum  VIEW_DIRECTION{NORTH, WEST, SOUTH, EAST};
    public VIEW_DIRECTION viewDirection;


    MapObject mapObject;


    public BlueMan(){
        init();
    }

    public void init() {
        super.init();
        mapObject = mapObjects.get("BlueMan");
        MapProperties properties = mapObject.getProperties();
    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
