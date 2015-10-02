package com.unlimitedstudios.fleebotbeta.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sagar on 2015-09-10.
 */
public class Constants {

    public static final int APP_HEIGHT = 480;
    public static final int APP_WIDTH = 800;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 50f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static final float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;
    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 15f);
    public static final Vector2 RUNNER_LINEAR_VELOCITY = new Vector2(5f, 0);

    public static final float PLATFORM_X = 25f;
    public static final float PLATFORM_DENSITY = RUNNER_DENSITY;
    public static final float PlATFORM_SMALL_Y = 3f;
    public static final float PLATFORM_MEDIUM_Y = 3.5f;
    public static final float PLATFORM_LARGE_Y = 4.5f;
    public static final Vector2 PLATFORM_LINEAR_VELOCITY = new Vector2(-5f, 0);
}
