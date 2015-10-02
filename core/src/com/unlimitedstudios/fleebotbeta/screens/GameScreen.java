package com.unlimitedstudios.fleebotbeta.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.unlimitedstudios.fleebotbeta.stages.GameStage;

/**
 * Created by Sagar on 2015-09-10.
 */
public class GameScreen implements Screen {

    private GameStage stage;

    public GameScreen(){
        stage = new GameStage();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // clear the stage
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // update the stage
        stage.draw();
        stage.act(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
