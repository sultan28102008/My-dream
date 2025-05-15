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

public class WinScreen implements Screen {

    Main main;

    TextButton buttonMenu;
    MovingBackground background;
    MovingBackground background1;




    public WinScreen(Main main) {
        this.main = main;

        buttonMenu = new TextButton(500, 300, "Menu");
        background = new MovingBackground("backgrounds/background-1.png");
        background1 = new MovingBackground("backgrounds/background-2.png",1);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        handleInput();

        background.move();
        background1.move();

        ScreenUtils.clear(0.68f, 0.87f, 0.39f, 1f);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();

        background1.draw(main.batch);
        background.draw(main.batch);
        buttonMenu.draw(main.batch);

        main.batch.end();

    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 vector = main.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

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
    }
}
