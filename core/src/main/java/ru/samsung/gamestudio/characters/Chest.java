package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.samsung.gamestudio.GamesSettings;

public class Chest {

    int x;
    int y;

    int width;
    int height;
    int speed = 10;

    Texture texture;

    boolean isPointReceived;


    public Chest(int width, int height) {
        this.width = width;
        this.height = height;

        x = GamesSettings.SCREEN_WIGHT;
        y = 80;

        texture = new Texture("Gold.png");
        isPointReceived = false;
    }

    public void move() {
        x -= speed;
    }

    public boolean isHit(Bird bird) {
        return bird.x + bird.width >= x;
    }


    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void dispose() {

        texture.dispose();
    }

}
