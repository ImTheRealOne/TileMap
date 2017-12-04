package com.mygdx.game.game.objects.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public abstract class   AbstractGameObject {
    TiledMap tiledMap;
    MapLayer layer;
    MapObjects mapObjects;
    public Vector2 position;
    public Vector2 dimension;
    public Vector2 origin;

    public AbstractGameObject() {
        //implementation for abstract game object constructor

    }

    protected  void updateMotionX(float deltaTime){
        //update object motion x


    }

    protected  void updateMotionY(float delatTime){

        //update object motion Y

    }

    public void update(float deltaTime){
        updateMotionX(deltaTime);
        updateMotionY(deltaTime);
        //update position
    }

    public  abstract  void render(SpriteBatch batch);
    public  void init() {
        tiledMap = new TmxMapLoader().load("android/assets/Test1.tmx");
        layer = tiledMap.getLayers().get("ObjLayer");
        mapObjects = layer.getObjects();
    }

}
