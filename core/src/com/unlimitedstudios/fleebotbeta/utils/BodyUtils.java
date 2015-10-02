package com.unlimitedstudios.fleebotbeta.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.unlimitedstudios.fleebotbeta.box2d.UserData;
import com.unlimitedstudios.fleebotbeta.enums.UserDataType;

/**
 * Created by Sagar on 2015-09-18.
 */
public class BodyUtils {

    public static boolean bodyInBounds(Body body) {
        UserData userdata = (UserData) body.getUserData();

        switch (userdata.getUserDataType()) {
            case RUNNER:
            case PLATFORM:
                return body.getPosition().x + userdata.getWidth() / 2 > 0;
        }
        return true;
    }

    public static boolean bodyIsPlatform(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.PLATFORM;
    }

    public static boolean bodyIsRunner(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.RUNNER;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }
}
