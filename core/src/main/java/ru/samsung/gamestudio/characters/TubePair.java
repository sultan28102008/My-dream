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

    Texture textureUpperTube;
    Texture textureLowerTube;

    int generateRandomY() {
        Random rand = new Random();
        return rand.nextInt(
            GamesSettings.SCREEN_HEIGHT
                - 2 * (GamesSettings.TUBE_PADDING
                + GamesSettings.GAP_HEIGHT / 2)
        ) + GamesSettings.TUBE_PADDING
            + GamesSettings.GAP_HEIGHT / 2;
    }

    public TubePair(int tubeWidth, int tubeHeight, int countOfTubes, int tubeIdx) {
        this.tubeWidth = tubeWidth;
        this.tubeHeight = tubeHeight;

        distanceBetweenTubes = (GamesSettings.SCREEN_WIGHT + tubeWidth) / (countOfTubes - 1);
        x = distanceBetweenTubes * tubeIdx + GamesSettings.SCREEN_WIGHT;
        gapY = generateRandomY();

        textureLowerTube = new Texture("tubes/tube.png");
        textureUpperTube = new Texture("tubes/tube_flipped.png");
    }

    public void move() {
        x -= speed;
        if (x <= -tubeWidth) {
            x = GamesSettings.SCREEN_WIGHT + distanceBetweenTubes;

            int newGapY = generateRandomY();
            while (newGapY == gapY) {
                newGapY = generateRandomY();
            }
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(textureUpperTube, x, gapY + GamesSettings.GAP_HEIGHT / 2f, tubeWidth, tubeHeight);
        batch.draw(textureLowerTube, x, gapY - GamesSettings.GAP_HEIGHT / 2f - tubeHeight, tubeWidth, tubeHeight);
    }

    public void dispose() {
        textureUpperTube.dispose();
        textureLowerTube.dispose();
    }

}
