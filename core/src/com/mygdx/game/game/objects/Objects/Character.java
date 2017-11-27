package com.mygdx.game.game.objects.Objects;

/**
 * Created by ImTheRealOne on 11/26/2017.
 */

public class Character  extends  AbstractGameObject{
    public static  final String TAG = Character.class.getName();

    public enum  VIEW_DIRECTION{NORTH, WEST, SOUTH, EAST};

    public VIEW_DIRECTION viewDirection;

    public Character(){
        init();
    }

    public void init() {


    }
}
