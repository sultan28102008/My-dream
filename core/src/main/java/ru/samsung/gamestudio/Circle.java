package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Circle {

    int size;
    int x;
    int y;
    int speedX;
    int speedY;

    int absSpeed;

    int textureCounter;
    Texture[] texture;

    Circle(int x, int y, int size, int speed, String[] pathToTexture) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speedX = speed;
        this.speedY = speed;
        this.absSpeed = speed;

        textureCounter = 0;
        texture = new Texture[pathToTexture.length];
        for (int i = 0; i < pathToTexture.length; i++) {
            texture[i] = new Texture(pathToTexture[i]);
        }

        // texture = new Texture(pathToTexture);
    }

    void move() {

        boolean wasHit = false;

        x += speedX;
        y += speedY;

        if (x > GamesSettings.SCREEN_WIGHT - size) {
            speedX = -absSpeed;
            wasHit = true;
        } else if (x < 0) {
            speedX = absSpeed;
            wasHit = true;
        }

        if (y > GamesSettings.SCREEN_HEIGHT - size) {
            speedY = -absSpeed;
            wasHit = true;
        } else if (y < 0) {
            speedY = absSpeed;
            wasHit = true;
        }

        if (wasHit) {
            textureCounter += 1;
            if (textureCounter >= texture.length) {
                textureCounter = 0;
            }
        }
    }

    void draw(SpriteBatch batch) {
        batch.draw(texture[textureCounter], x, y, size, size);
    }

    void dispose() {
        for (Texture value : texture) {
            value.dispose();
        }
    }

}
