package com.unlimitedstudios.fleebotbeta.box2d;

import com.badlogic.gdx.math.Vector2;
import com.unlimitedstudios.fleebotbeta.enums.UserDataType;
import com.unlimitedstudios.fleebotbeta.utils.Constants;

/**
 * Created by Sagar on 2015-09-26.
 */
public class PlatformUserData extends UserData{

    private Vector2 linearVelocity;

    public PlatformUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.PLATFORM;
        linearVelocity = Constants.PLATFORM_LINEAR_VELOCITY;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }
}
