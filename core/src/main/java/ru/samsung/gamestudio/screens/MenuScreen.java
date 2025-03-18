package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.Main;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.TextButton;

public class MenuScreen implements Screen {

    Main main;

    MovingBackground background;
    TextButton startButton;
    TextButton exitButton;

    public MenuScreen(Main main) {
        this.main = main;

        background = new MovingBackground("backgrounds/restart_bg.png");
        startButton = new TextButton(100, 400, "Start");
        exitButton = new TextButton(700, 400, "Exit");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        background.move();

        handleInput();

        ScreenUtils.clear(1f, 1f, 1f, 1f);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();

        background.draw(main.batch);
        startButton.draw(main.batch);
        exitButton.draw(main.batch);

        main.batch.end();

    }

    void handleInput() {
        if (Gdx.input.justTouched()) {

            Vector3 vector = main.camera.unproject(new Vector3(
                Gdx.input.getX(),
                Gdx.input.getY(),
                0
            ));

            if (startButton.isHit((int) vector.x, (int) vector.y)) {
                main.setScreen(main.gameScreen);
            } else if (exitButton.isHit((int) vector.x, (int) vector.y)) {
                Gdx.app.exit();
            }

        }
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
