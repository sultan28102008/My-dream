package ru.samsung.gamestudio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;

    Circle circle;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("texture/circle.png");
        // blueCircle = new Texture("texture/circle2.png");

        String[] paths = {
            "texture/circle2.png",
            "texture/circle.png"
        };

        circle = new Circle(
            20, 300,
            150, 5,
            paths
        );
    }

    @Override
    public void render() {

        circle.move();

        ScreenUtils.clear(1f, 1f, 1f, 1f);

        batch.begin();

        // batch.draw(image, 0, 0, circleSize, circleSize);
        // batch.draw(image, 0, GamesSettings.SCREEN_HEIGHT - circleSize, circleSize, circleSize);
        // batch.draw(image, GamesSettings.SCREEN_WIGHT - circleSize, 0, circleSize, circleSize);
        // batch.draw(image, GamesSettings.SCREEN_WIGHT - circleSize, GamesSettings.SCREEN_HEIGHT - circleSize, circleSize, circleSize);

        circle.draw(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
