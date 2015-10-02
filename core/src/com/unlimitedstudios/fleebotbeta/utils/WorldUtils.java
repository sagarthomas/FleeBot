package com.unlimitedstudios.fleebotbeta.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.unlimitedstudios.fleebotbeta.box2d.GroundUserData;
import com.unlimitedstudios.fleebotbeta.box2d.PlatformUserData;
import com.unlimitedstudios.fleebotbeta.box2d.RunnerUserData;
import com.unlimitedstudios.fleebotbeta.enums.PlatformType;

/**
 * Created by Sagar on 2015-09-10.
 */
public class WorldUtils {

    public  static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
        body.createFixture(shape, Constants.GROUND_DENSITY);
        body.setUserData( new GroundUserData());
        shape.dispose();
        return body;
    }

    public static Body createRunner(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.RUNNER_WIDTH / 2, Constants.RUNNER_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.RUNNER_GRAVITY_SCALE);
        body.createFixture(shape, Constants.RUNNER_DENSITY);
        body.resetMassData();
        body.setUserData( new RunnerUserData(Constants.RUNNER_WIDTH, Constants.RUNNER_HEIGHT));
        shape.dispose();
        return body;
    }

    public static Body createPlatform(World world) {
        PlatformType platformType = RandomUtils.getRandomPlatformType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(platformType.getX(), platformType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(platformType.getWidth() / 2, platformType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, platformType.getDensity());
        body.resetMassData();
        PlatformUserData userData = new PlatformUserData(platformType.getWidth(), platformType.getHeight());
        body.setUserData(userData);
        shape.dispose();
        return body;
    }
}
