package io.github.mufca.libgdx.gui.core;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.github.tommyettinger.textra.KnownFonts;
import com.github.tommyettinger.textra.TypingLabel;

import java.util.Random;

public class CoreTypingLabel extends TypingLabel {
    public CoreTypingLabel() {
        super();
        this.setFont(CoreConstants.getFont());
    }
}
