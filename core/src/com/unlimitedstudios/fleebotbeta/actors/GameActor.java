package com.unlimitedstudios.fleebotbeta.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.unlimitedstudios.fleebotbeta.box2d.UserData;

/**
 * Created by Sagar on 2015-09-11.
 */
public abstract class GameActor extends Actor {

    protected Body body;
    protected UserData userData;

    public GameActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }

    public abstract UserData getUserData();
}
