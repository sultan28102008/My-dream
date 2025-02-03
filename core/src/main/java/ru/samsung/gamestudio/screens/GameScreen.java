package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.GamesSettings;
import ru.samsung.gamestudio.Main;

public class GameScreen implements Screen {

    Texture circle;
    Main main;

    public GameScreen(Main main) {
        this.main = main;
        circle = new Texture("texture/circle.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1f, 1f, 1f, 1f);

        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();
        main.batch.draw(circle, 0, 0, 100, 100);
        main.batch.draw(circle, GamesSettings.SCREEN_WIGHT - 100, GamesSettings.SCREEN_HEIGHT - 100, 100, 100);
        main.batch.end();

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
