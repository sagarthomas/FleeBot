package com.unlimitedstudios.fleebotbeta.box2d;

import com.badlogic.gdx.math.Vector2;
import com.unlimitedstudios.fleebotbeta.utils.Constants;


/**
 * Created by Sagar on 2015-09-11.
 */
public class RunnerUserData extends UserData {

    private final Vector2 runningPosition = new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y);
    private final Vector2 dodgingPosition = new Vector2(Constants.RUNNER_DODGE_X, Constants.RUNNER_DODGE_Y);
    private Vector2 jumpingLinearImpulse;
    private Vector2 runningLinearVelocity;

    public RunnerUserData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
        runningLinearVelocity = Constants.RUNNER_LINEAR_VELOCITY;
        userDataType = userDataType.RUNNER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }
    public Vector2 getRunningLinearVelocity() {return runningLinearVelocity;}

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

    public float getDodgeAngle() {
        // in radians
        return (float) (-90f * (Math.PI / 180f));
    }

    public Vector2 getRunningPosition() {
        return runningPosition;
    }

    public Vector2 getDodgingPosition() {
        return dodgingPosition;
    }
}
