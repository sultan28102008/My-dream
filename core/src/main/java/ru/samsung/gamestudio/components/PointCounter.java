package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PointCounter {

    int x;
    int y;
    BitmapFont font;

    public PointCounter(int x, int y) {
        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().setScale(5);
        font.setColor(Color.WHITE);
    }

    public void draw(Batch batch, int countOfPoints) {
        font.draw(batch, "Score: " + countOfPoints, x, y);
        // "Score: " + 123 == "Score: 123"
    }

    public void dispose() {
        font.dispose();
    }

}
