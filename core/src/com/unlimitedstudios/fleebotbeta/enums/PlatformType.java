package com.unlimitedstudios.fleebotbeta.enums;

import com.unlimitedstudios.fleebotbeta.utils.Constants;

/**
 * Created by Sagar on 2015-09-24.
 */
public enum PlatformType {

    SMALL_PLATFORM(3f, 1f, Constants.PLATFORM_X, Constants.PlATFORM_SMALL_Y, Constants.PLATFORM_DENSITY),
    MED_PLATFORM(5f, 1f, Constants.PLATFORM_X, Constants.PLATFORM_MEDIUM_Y, Constants.PLATFORM_DENSITY);


    private float width;
    private float height;
    private float x;
    private float y;
    private float density;

    PlatformType(float width, float height, float x, float y, float density) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
    }

    public float getWidth() {return width;}

    public float getHeight() {return height;}

    public float getX() {return x;}

    public float getY() {return y;}

    public float getDensity() {return density;}

}
