package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.Main;
import ru.samsung.gamestudio.characters.TubePair;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.PointCounter;
import ru.samsung.gamestudio.components.TextButton;

public class RestartScreen implements Screen {

    Main main;

    TextButton buttonRestart;
    TextButton buttonMenu;
    MovingBackground background;
    PointCounter pointCounter;

    int gamePoints;

    public RestartScreen(Main main) {
        this.main = main;

        buttonMenu = new TextButton(100, 150, "Menu");
        buttonRestart = new TextButton(100, 400, "Restart");
        background = new MovingBackground("backgrounds/restart_bg.png");
        pointCounter = new PointCounter(700, 500);
    }

    public void setGamePoints(int gamePoints) {
        this.gamePoints = gamePoints;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        handleInput();

        background.move();

        ScreenUtils.clear(1f, 1f, 1f, 1f);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();

        background.draw(main.batch);
        buttonRestart.draw(main.batch);
        buttonMenu.draw(main.batch);
        pointCounter.draw(main.batch, gamePoints);

        main.batch.end();

    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 vector = main.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (buttonRestart.isHit((int) vector.x, (int) vector.y)) {
                main.setScreen(main.gameScreen);
            }
            if (buttonMenu.isHit((int) vector.x, (int) vector.y)) {
                main.setScreen(main.menuScreen);
            }

        }
    }

    @Override
    public void resize(int i, int i1) {

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
        buttonMenu.dispose();
        buttonRestart.dispose();
    }
}
