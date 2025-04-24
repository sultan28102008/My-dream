package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.samsung.gamestudio.GamesSettings;

import java.util.Random;

public class TubePair {

    int x;
    int gapY;

    int tubeWidth;
    int tubeHeight;
    int distanceBetweenTubes;
    int speed = 10;

    int selectedTexture;
    Texture textureLowerTube;
    Texture stoneTube;

    boolean isPointReceived;

    int generateRandomY() {
        Random rand = new Random();
        return rand.nextInt(100
        ) + GamesSettings.TUBE_PADDING + GamesSettings.GAP_HEIGHT / 2;
    }

    public TubePair(int tubeWidth, int tubeHeight, int countOfTubes, int tubeIdx) {
        this.tubeWidth = tubeWidth;
        this.tubeHeight = tubeHeight;

        distanceBetweenTubes = (GamesSettings.SCREEN_WIGHT + tubeWidth) / (countOfTubes - 1);
        x = distanceBetweenTubes * tubeIdx + GamesSettings.SCREEN_WIGHT;
        gapY = generateRandomY();

        textureLowerTube = new Texture("tubes/tube.png");
        stoneTube = new Texture("tubes/tube1.png");
        isPointReceived = false;
    }

    public void move() {
        x -= speed;
        if (x <= -tubeWidth) {
            x = GamesSettings.SCREEN_WIGHT + distanceBetweenTubes;
            selectedTexture = (int) (Math.random() * 2);

            int newGapY = generateRandomY();
            while (newGapY == gapY) {
                newGapY = generateRandomY();
            }
            gapY = newGapY;

            isPointReceived = false;
        }
    }

    public boolean isHit(Bird bird) {
        boolean isHitByX = bird.x + bird.width >= x && bird.x <= x + tubeWidth;
        // down tube collision
        if (isHitByX && bird.y <= gapY - GamesSettings.GAP_HEIGHT / 2f) {
            return true;
        }


        return false;
    }

    public boolean needAddPoint(Bird bird) {
        if (!isPointReceived && bird.x > x + tubeWidth) {
            isPointReceived = true;
            return true;
        }
        return false;
    }

    public void draw(SpriteBatch batch) {
        Texture texture;
        if (selectedTexture == 1){
            texture = textureLowerTube;
        } else {
            texture = stoneTube;
        }

        batch.draw(texture, x, gapY - GamesSettings.GAP_HEIGHT / 2f - tubeHeight, tubeWidth, tubeHeight);
    }

    public void dispose() {

        textureLowerTube.dispose();
    }

}
