package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.GamesSettings;
import ru.samsung.gamestudio.Main;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.characters.Chest;
import ru.samsung.gamestudio.characters.TubePair;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.PointCounter;

public class GameScreen implements Screen {

    Main main;
    Bird bird;
    Chest chest;

    MovingBackground movingBackground;
    PointCounter pointCounter;

    int gamePoints;
    boolean showTubes;

    TubePair[] tubePairs;

    public GameScreen(Main main) {
        this.main = main;

        chest = new Chest(150, 150);
        movingBackground = new MovingBackground("backgrounds/game_bg.png");
        pointCounter = new PointCounter(GamesSettings.SCREEN_WIGHT - 400, GamesSettings.SCREEN_HEIGHT - 20);
    }

    @Override
    public void show() {
        showTubes = true;
        bird = new Bird(
            100, GamesSettings.SCREEN_HEIGHT / 2 - 100 / 2,
            100, 140,
            8
        );
        chest = new Chest(150,150);

        tubePairs = new TubePair[3];
        for (int i = 0; i < tubePairs.length; i++) {
            tubePairs[i] = new TubePair(75, 210, tubePairs.length, i);
        }

        gamePoints = 0;

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            if (bird.onClick()) {
                main.audioManager.jumpSound.play(0.1f);
            }
        }
        if (showTubes) {
            for (TubePair tubePair : tubePairs) {
                tubePair.move();
                if (tubePair.isHit(bird)) {
                    endGame();
                } else if (tubePair.needAddPoint(bird)) {
                    gamePoints += 1;
                    if (gamePoints % 10 == 0) {
                        showTubes = false;
                    }
                }
            }
        } else {
            chest.move();
            if (chest.isHit(bird)) {
                winGame();
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
        if (showTubes) {
            for (TubePair tubePair : tubePairs) {
                tubePair.draw(main.batch);
            }
        }else {
            chest.draw(main.batch);
        }
        pointCounter.draw(main.batch, gamePoints);

        main.batch.end();

    }

    public void endGame() {
        main.restartScreen.setGamePoints(gamePoints);
        main.audioManager.hitSound.play(0.3f);
        main.setScreen(main.restartScreen);
    }
    public void winGame(){
        main.setScreen(main.winScreen);
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
