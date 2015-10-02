package com.unlimitedstudios.fleebotbeta.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.unlimitedstudios.fleebotbeta.box2d.GroundUserData;

/**
 * Created by Sagar on 2015-09-11.
 */
public class Ground extends GameActor {

    public Ground(Body body) {
        super(body);
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }
}
