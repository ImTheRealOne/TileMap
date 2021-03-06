package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.util.Constants;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class WorldRenderer implements Disposable {
    private OrthographicCamera camera;
    private  OrthographicCamera cameraGUI;
    private  WorldController worldController;
    private SpriteBatch batch;
    IsometricTiledMapRenderer tiledMapRenderer;
    TiledMap tiledMap;

    public WorldRenderer(WorldController worldController){
        this.worldController = worldController;
        init();
    }

    public void init(){
        batch = new SpriteBatch();
        //initialize tile map in level
        tiledMap = new TmxMapLoader().load("android/assets/Test1.tmx");
        tiledMapRenderer = new IsometricTiledMapRenderer(tiledMap);

        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
                Constants.VIEWPORT_HEIGHT);
        camera.position.set(200,200,0);
        camera.update();
        cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH,
                Constants.VIEWPORT_GUI_HEIGHT);
        cameraGUI.position.set(0, 0, 0);
        cameraGUI.setToOrtho(true); // flip y-axis
        cameraGUI.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

    }

    public void resize  (int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height) * width;
        camera.update();
        cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
        cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT
                / (float)height) * (float)width;
        cameraGUI.position.set(cameraGUI.viewportWidth / 2,
                cameraGUI.viewportHeight / 2, 0);
        cameraGUI.update();
    }

    public  void render()   {
        renderWorld(batch);
        //renderGui(batch);
    }

    public void renderWorld(SpriteBatch batch){

        worldController.cameraHelper.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);
        tiledMapRenderer.setView(camera);

        batch.begin();
        tiledMapRenderer.render();
        batch.end();
    }

    @Override
    public void dispose(){
        tiledMap.dispose();
        tiledMapRenderer.dispose();
        batch.dispose();

    }
}
