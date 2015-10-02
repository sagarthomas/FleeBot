package com.unlimitedstudios.fleebotbeta.box2d;

import com.unlimitedstudios.fleebotbeta.enums.UserDataType;

/**
 * Created by Sagar on 2015-09-11.
 */
public abstract class UserData {

    protected UserDataType userDataType;
    protected float width;
    protected float height;

    public UserData() {

    }

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }
    public UserDataType getUserDataType() {
        return userDataType;
    }

    // getters and setters
    public float getWidth() {return width;}

    public float getHeight() {return height;}

    public void setWidth(float width) {this.width = width;}

    public void setHeight(float height) {this.height = height;}
}
