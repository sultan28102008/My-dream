package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.Main;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.TextButton;

public class MenuScreen implements Screen {

    Main main;

    MovingBackground background;
    MovingBackground background1;
    TextButton startButton;
    TextButton exitButton;
    Texture titleTexture;

    public MenuScreen(Main main) {
        this.main = main;

        background = new MovingBackground("backgrounds/background-1.png");
        background1 = new MovingBackground("backgrounds/background-2.png",1);
        startButton = new TextButton(200, 200, "Start");
        exitButton = new TextButton(750, 200, "Exit");
        titleTexture = new Texture("title.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        background.move();
        background1.move();

        handleInput();

        ScreenUtils.clear(0.68f, 0.87f, 0.39f, 1f);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();

        background1.draw(main.batch);
        background.draw(main.batch);
        startButton.draw(main.batch);
        exitButton.draw(main.batch);
        main.batch.draw(titleTexture,390,450,492,66);

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
