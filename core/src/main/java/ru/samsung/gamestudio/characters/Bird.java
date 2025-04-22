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

    final int maxHeightOfFly = 200;//высота прыжка
    int heightOfFly;
    boolean isFlying;
    boolean canFly;
    Texture[] textures;
    int textureCounter;

    public Bird(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;

        textureCounter = 0;
        textures = new Texture[]{
            new Texture("birdTiles/tile1.png"),
            new Texture("birdTiles/tile2.png"),
            new Texture("birdTiles/tile3.png"),
            new Texture("birdTiles/tile4.png"),
            new Texture("birdTiles/tile5.png"),
            new Texture("birdTiles/tile6.png"),
            new Texture("birdTiles/tile7.png"),
            new Texture("birdTiles/tile8.png")

        };

    }

    public boolean onClick() {
        if (canFly == true) {
            isFlying = true;
            heightOfFly = y + maxHeightOfFly;
            canFly = false;
            return true;
        }
        return false;
    }

    public void fly() {

        if (isFlying) {
            y += speed;
        } else {
            if (y <= 70) {
                y = 70;
                canFly = true;
            } else {
                y -= speed;
            }

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
