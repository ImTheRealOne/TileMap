package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.util.CameraHelper;
import com.mygdx.game.util.Constants;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class WorldController extends InputAdapter{
    private Game game;
    public CameraHelper cameraHelper;


    private static final String TAG = WorldController.class.getName();

    public WorldController () { init(); }

    public WorldController (Game game) {
        this.game = game;
        init();
    }

    private void backToMenu () {
        // switch to menu screen
        game.setScreen(new MenuScreen(game));
    }

    private  void init(){
        cameraHelper = new CameraHelper();
        Gdx.input.setInputProcessor(this);
        //initLevel();
    }

    public void update (float deltaTime) {
        handleDebugInput(deltaTime);
                    //reimplment update function for world controller


                    //        if (isGameOver()) {
                    //            timeLeftGameOverDelay -= deltaTime;
                    //            if (timeLeftGameOverDelay < 0) backToMenu();
                    //        } else {
                    //            handleInputGame(deltaTime);
                    //        }
                    //        level.update(deltaTime);
                    //        testCollisions();
                    //        cameraHelper.update(deltaTime);
                    //        if (!isGameOver() && isPlayerInWater()) {
                    //            lives--;
                    //            if (isGameOver())
                    //                timeLeftGameOverDelay = Constants.TIME_DELAY_GAME_OVER;
                    //            else
                    //                initLevel();
                    //        }
    }

    private void handleDebugInput (float deltaTime) {
        if (Gdx.app.getType() != Application.ApplicationType.Desktop) return;

       /*
        // Selected Sprite Controls
        float sprMoveSpeed = 5 * deltaTime;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) moveSelectedSprite(
                -sprMoveSpeed, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            moveSelectedSprite(sprMoveSpeed, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.W)) moveSelectedSprite(0,
                sprMoveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.S)) moveSelectedSprite(0,
                -sprMoveSpeed);
        */

        if (!cameraHelper.hasTarget(/*target*/)) {
            // Camera Controls (move)
            float camMoveSpeed = 5 * deltaTime;
            float camMoveSpeedAccelerationFactor = 5;
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) camMoveSpeed *=
                    camMoveSpeedAccelerationFactor;
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) moveCamera(-camMoveSpeed,
                    0);
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moveCamera(camMoveSpeed,
                    0);
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) moveCamera(0, camMoveSpeed);
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) moveCamera(0,
                    -camMoveSpeed);
            if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE))
                cameraHelper.setPosition(0, 0);
        }
        // Camera Controls (zoom)
        float camZoomSpeed = 1 * deltaTime;
        float camZoomSpeedAccelerationFactor = 5;
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) camZoomSpeed *=
                camZoomSpeedAccelerationFactor;
        if (Gdx.input.isKeyPressed(Input.Keys.COMMA))
            cameraHelper.addZoom(camZoomSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.PERIOD)) cameraHelper.addZoom(
                -camZoomSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.SLASH)) cameraHelper.setZoom(1);


    }

    private void moveCamera (float x, float y) {
        x += cameraHelper.getPosition().x;
        y += cameraHelper.getPosition().y;
        cameraHelper.setPosition(x, y);
    }

    @Override
    public boolean keyUp (int keycode) {
        // Reset game world
        if (keycode == Input.Keys.R) {
            init();
            Gdx.app.debug(TAG, "Game world resetted");
        }

        // Toggle camera follow
        else if (keycode == Input.Keys.ENTER) {

            Gdx.app.debug(TAG, "Camera follow enabled: "
                    + cameraHelper.hasTarget());
        }



        return false;
    }

    private void handleInputGame (float deltaTime) {
            //game input control
        }
}
