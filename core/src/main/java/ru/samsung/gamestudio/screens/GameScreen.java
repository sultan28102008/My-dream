package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.GamesSettings;
import ru.samsung.gamestudio.Main;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.characters.TubePair;

public class GameScreen implements Screen {

    Main main;
    Bird bird;

    TubePair[] tubePairs;

    public GameScreen(Main main) {
        this.main = main;

        bird = new Bird(
            100, GamesSettings.SCREEN_HEIGHT / 2 - 100 / 2,
            100, 100,
            5
        );

        tubePairs = new TubePair[3];
        for (int i = 0; i < tubePairs.length; i++) {
            tubePairs[i] = new TubePair(75, 425, tubePairs.length, i);
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        for (TubePair tubePair : tubePairs) {
            tubePair.move();
            if (tubePair.isHit(bird)) {
                System.out.println("Bird was hit");
            }
        }

        bird.fly();

        ScreenUtils.clear(1f, 1f, 1f, 1f);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();
        bird.draw(main.batch);
        for (TubePair tubePair : tubePairs) {
            tubePair.draw(main.batch);
        }
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
        bird.dispose();
    }
}
