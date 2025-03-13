package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class TextButton {

    BitmapFont font;
    Texture texture;
    String text;

    int textureX;
    int textureY;
    int textX;
    int textY;

    int textureWidth;
    int textureHeight;
    int textWidth;
    int textHeight;

    public TextButton(int x, int y, String text) {
        this.textureX = x;
        this.textureY = y;
        this.text = text;

        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);

        GlyphLayout glyphLayout = new GlyphLayout(font, text);
        textWidth = (int) glyphLayout.width;
        textHeight = (int) glyphLayout.height;

        texture = new Texture("button_bg.png");
        textureWidth = texture.getWidth();
        textureHeight = texture.getHeight();

        textX = x + (textureWidth - textWidth) / 2;
        textY = y + (textureHeight + textHeight) / 2;
    }

    public void draw(Batch batch) {
        batch.draw(texture, textureX, textureY, textureWidth, textureHeight);
        font.draw(batch, text, textX, textY);
    }

    public void dispose() {
        texture.dispose();
        font.dispose();
    }

    public boolean isHit(int touchX, int touchY) {

        return touchX >= textureX && touchX <= textureX + textureWidth
            && touchY >= textureY && touchY <= textureY + textureHeight;

    }


}
