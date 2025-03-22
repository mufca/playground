package io.github.mufca.libgdx.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.github.tommyettinger.textra.TypingLabel;
import io.github.mufca.libgdx.gui.core.CoreConstants;
import io.github.mufca.libgdx.gui.core.CoreTable;
import io.github.mufca.libgdx.gui.core.CoreTypingLabel;
import io.github.mufca.libgdx.gui.core.TextureConstants;
import io.github.mufca.libgdx.temporarytrash.ParagraphParameters;
import io.github.mufca.libgdx.temporarytrash.TextProcessor;

import static io.github.mufca.libgdx.gui.core.CoreConstants.TRACER_SKIN;
import static io.github.mufca.libgdx.gui.core.TextureConstants.ORC_FEMALE_PORTRAIT;

public class Paragraph extends CoreTable {
    private final Label typingLabel;
    private final Image image;

    public Paragraph(ParagraphParameters paragraphParameters) {
        super();
        String processedText = TextProcessor.processText(paragraphParameters.text());
        typingLabel = new Label(processedText, TRACER_SKIN);
        typingLabel.setText(processedText);
        image = new Image(ORC_FEMALE_PORTRAIT);
        this.add(image);
        this.add(typingLabel).expandX();
    }

    @Override
    public boolean remove() {
        typingLabel.remove();
        image.remove();
        return super.remove();
    }
}
