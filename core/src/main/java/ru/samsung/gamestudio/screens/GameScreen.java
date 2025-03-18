package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.GamesSettings;
import ru.samsung.gamestudio.Main;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.characters.TubePair;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.PointCounter;

public class GameScreen implements Screen {

    Main main;
    Bird bird;

    MovingBackground movingBackground;
    PointCounter pointCounter;

    int gamePoints;

    TubePair[] tubePairs;

    public GameScreen(Main main) {
        this.main = main;

        movingBackground = new MovingBackground("backgrounds/game_bg.png");
        pointCounter = new PointCounter(GamesSettings.SCREEN_WIGHT - 400, GamesSettings.SCREEN_HEIGHT - 20);
    }

    @Override
    public void show() {

        bird = new Bird(
            100, GamesSettings.SCREEN_HEIGHT / 2 - 100 / 2,
            100, 100,
            5
        );

        tubePairs = new TubePair[3];
        for (int i = 0; i < tubePairs.length; i++) {
            tubePairs[i] = new TubePair(75, 425, tubePairs.length, i);
        }

        gamePoints = 0;

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        for (TubePair tubePair : tubePairs) {
            tubePair.move();
            if (tubePair.isHit(bird)) {
                endGame();
            } else if (tubePair.needAddPoint(bird)) {
                gamePoints += 1;
            }
        }

        movingBackground.move();
        bird.fly();

        ScreenUtils.clear(1f, 1f, 1f, 1f);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();

        movingBackground.draw(main.batch);
        bird.draw(main.batch);
        for (TubePair tubePair : tubePairs) {
            tubePair.draw(main.batch);
        }
        pointCounter.draw(main.batch, gamePoints);

        main.batch.end();

    }

    public void endGame() {
        main.restartScreen.setGamePoints(gamePoints);
        main.setScreen(main.restartScreen);
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
        movingBackground.dispose();
        pointCounter.dispose();
    }
}
