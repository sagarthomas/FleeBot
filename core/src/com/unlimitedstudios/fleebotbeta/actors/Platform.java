package com.unlimitedstudios.fleebotbeta.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.unlimitedstudios.fleebotbeta.box2d.PlatformUserData;

/**
 * Created by Sagar on 2015-09-26.
 */
public class Platform extends GameActor {

    public Platform(Body body) {
        super(body);
    }

    @Override
    public PlatformUserData getUserData() {
        return (PlatformUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
}
