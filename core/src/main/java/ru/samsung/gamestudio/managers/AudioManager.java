package ru.samsung.gamestudio.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

    public Music backgroundMusic;
    public Sound jumpSound;
    public Sound hitSound;

    public AudioManager() {
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/background.mp3"));
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("sound/jump.mp3"));
        hitSound = Gdx.audio.newSound(Gdx.files.internal("sound/lose.mp3"));

        backgroundMusic.setVolume(0.2f);
        backgroundMusic.setLooping(true);
    }
}
