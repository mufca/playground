package io.github.mufca.libgdx.gui.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.github.tommyettinger.textra.Font;
import com.github.tommyettinger.textra.KnownFonts;

public class CoreConstants {
    private final static FreeTypeFontGenerator generator = new FreeTypeFontGenerator(new FileHandle("fonts/NotoSans_Condensed-Light.ttf"));
    private static FreeTypeFontParameter parameter = new FreeTypeFontParameter();
    private static Font defaultFont;


    public final static Skin TRACER_SKIN = new Skin(new FileHandle("tracer/skin/tracer-ui.json"));

    public static Font getFont() {
        parameter.size = 25;
        parameter.color = Color.WHITE;
        if (defaultFont != null) {
            return defaultFont;
        } else {
            defaultFont = new Font(generator.generateFont(parameter));
            return defaultFont;
        }
    }


}
