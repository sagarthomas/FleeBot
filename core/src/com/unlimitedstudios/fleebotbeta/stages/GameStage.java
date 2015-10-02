package com.unlimitedstudios.fleebotbeta.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.unlimitedstudios.fleebotbeta.actors.Ground;
import com.unlimitedstudios.fleebotbeta.actors.Platform;
import com.unlimitedstudios.fleebotbeta.actors.Runner;
import com.unlimitedstudios.fleebotbeta.utils.BodyUtils;
import com.unlimitedstudios.fleebotbeta.utils.WorldUtils;



/**
 * Created by Sagar on 2015-09-10.
 */
public class GameStage extends Stage implements ContactListener{

    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 13;

    private World world;
    private Ground ground;
    private Runner runner;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenRightSide;
    private Rectangle screenLeftSide;
    private Vector3 touchPoint;

    public GameStage() {
        setUpWorld();
        setupCamera();
        setupTouchArea();
        renderer = new Box2DDebugRenderer();
    }

    private void setUpWorld() {
        world = WorldUtils.createWorld();
        // let world know you are handling contact
        world.setContactListener(this);
        setUpGround();
        setUpRunner();
        createPlatform();


    }

    private void setUpGround() {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setUpRunner() {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void setupTouchArea() {
        touchPoint = new Vector3();
        screenRightSide = new Rectangle(getCamera().viewportWidth/2, 0 , getCamera().viewportWidth/2, getCamera().viewportHeight);
        screenLeftSide = new Rectangle(0, 0 , getCamera().viewportWidth / 2, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }


        // fixed timestep
        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        // implement interpolation
    }

    private void update(Body body) {
        if (!BodyUtils.bodyInBounds(body)) {
            if (BodyUtils.bodyIsPlatform(body)) {
                createPlatform();
            }
            world.destroyBody(body);
        }
    }

    private void createPlatform() {
        Platform platform = new Platform(WorldUtils.createPlatform(world));
        addActor(platform);
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        // get the actual coordinates
        translateScreenToWorldCoordinates(x, y);

        if (rightSideTouched(touchPoint.x, touchPoint.y)) {
            runner.jump();
        }
        else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
            runner.dodge();
        }
        return super.touchDown(x, y, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (runner.isDodging()) {
            runner.stopDodge();
        }

        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean keyDown (int keycode) {
        if (keycode == Input.Keys.DPAD_UP) {
            runner.jump();
        }
        if (keycode == Input.Keys.DPAD_DOWN) {
            runner.dodge();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.DPAD_DOWN) {
            if (runner.isDodging()) {
                runner.stopDodge();
            }
        }
        return true;
    }

    private boolean rightSideTouched(float x, float y) {
        return screenRightSide.contains(x, y);
    }

    private boolean leftSideTouched(float x, float y) {
        return screenLeftSide.contains(x, y);
    }

    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }



    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) || (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            runner.landed();
        }
        else if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsPlatform(b)) || (BodyUtils.bodyIsRunner(b) && BodyUtils.bodyIsPlatform(a))) {
            runner.onPlatform();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
