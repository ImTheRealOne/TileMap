package com.mygdx.game.game.objects.Objects;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public abstract class   AbstractGameObject {

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


}
