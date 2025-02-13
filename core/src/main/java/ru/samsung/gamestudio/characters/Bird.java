package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {

    private int frameIdx;

    int x;
    int y;
    int width;
    int height;

    int speed;

    final int maxHeightOfFly = 100;
    int heightOfFly;
    boolean isFlying;

    Texture[] textures;
    int textureCounter;

    public Bird(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;

        textureCounter = 0;
        textures = new Texture[] {
            new Texture("birdTiles/bird0.png"),
            new Texture("birdTiles/bird1.png"),
            new Texture("birdTiles/bird2.png"),
            new Texture("birdTiles/bird1.png"),
        };

    }

    public void onClick() {
        isFlying = true;
        heightOfFly = y + maxHeightOfFly;
    }

    public void fly() {

        if (isFlying) {
            y += speed;
        } else {
            y -= speed;
        }

        if (y > heightOfFly) {
            isFlying = false;
        }

    }

    public void draw(SpriteBatch batch) {
        frameIdx += 1;
        if (frameIdx % 5 == 0) {
            textureCounter = (textureCounter + 1) % textures.length;
        }
        batch.draw(textures[textureCounter], x, y, width, height);
    }

    public void dispose() {
        for (Texture texture : textures) {
            texture.dispose();
        }
    }

}
