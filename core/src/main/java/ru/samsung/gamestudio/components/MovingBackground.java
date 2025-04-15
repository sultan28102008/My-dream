package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.samsung.gamestudio.GamesSettings;

public class MovingBackground {

    Texture texture;

    int textureX1;
    int textureX2;

    int speed = 2;

    public MovingBackground(String texturePath) {
        texture = new Texture(texturePath);
        textureX1 = 0;
        textureX2 = GamesSettings.SCREEN_WIGHT;
    }
    public MovingBackground(String texturePath,int speed) {
        this.speed=speed;
        texture = new Texture(texturePath);
        textureX1 = 0;
        textureX2 = GamesSettings.SCREEN_WIGHT;
    }

    public void move() {
        textureX1 -= speed;
        textureX2 -= speed;

        if (textureX1 < -GamesSettings.SCREEN_WIGHT) {
            textureX1 = GamesSettings.SCREEN_WIGHT;
        }
        if (textureX2 < -GamesSettings.SCREEN_WIGHT) {
            textureX2 = GamesSettings.SCREEN_WIGHT;
        }
    }

    public void draw(Batch batch) {
        batch.draw(texture, textureX1, 0, GamesSettings.SCREEN_WIGHT + 2, GamesSettings.SCREEN_HEIGHT);
        batch.draw(texture, textureX2, 0, GamesSettings.SCREEN_WIGHT + 2, GamesSettings.SCREEN_HEIGHT);
    }

    public void dispose() {
        texture.dispose();
    }

}
