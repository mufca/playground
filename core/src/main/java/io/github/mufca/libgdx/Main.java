package io.github.mufca.libgdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.files.FileHandle;

import java.util.Arrays;
import java.util.Optional;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
        changeToBorderless();
        setScreen(new Screen());
    }

    private static void changeToBorderless() {
        Graphics.DisplayMode displayMode = Arrays.stream(Gdx.graphics.getDisplayModes()).sequential()
            .reduce((first, second) -> second).orElseThrow();
        Gdx.graphics.setUndecorated(true);
        Gdx.graphics.setWindowedMode(displayMode.width, displayMode.height);
    }
}
