package com.unlimitedstudios.fleebotbeta.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.unlimitedstudios.fleebotbeta.box2d.RunnerUserData;

/**
 * Created by Sagar on 2015-09-11.
 */
public class Runner extends GameActor {

    private boolean jumped;
    private boolean dodging;

    public Runner(Body body) {
        super(body);
    }

    @Override
    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    public void jump() {

        if(!jumped) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumped = true;
        }
    }

    public void landed() {
        jumped = false;
    }

    public void onPlatform() {
        jumped = false;
        body.applyLinearImpulse(getUserData().getRunningLinearVelocity(), body.getWorldCenter(), true);
        //body.applyForce(getUserData().getRunningLinearVelocity(), body.getWorldCenter(), true);
    }

    public void dodge() {
        if (!jumped) {
            body.setTransform(getUserData().getDodgingPosition(), getUserData().getDodgeAngle());
            dodging = true;

        }
    }

    public void stopDodge() {
        dodging = false;
        body.setTransform(getUserData().getRunningPosition(), 0.f);
    }

    public boolean isDodging() {
        return dodging;
    }
}
