package io.github.mufca.libgdx.temporarytrash;

import java.util.List;
import java.util.Random;

public class ParagraphConstants {
    private static final String SHORT_PARAGRAPH = "This is a paragraph";
    private static final String LONG_PARAGRAPH = "This is a long paragraph that is used to test the scrolling " +
        "functionality of the paragraph class. This is a long paragraph that is used to test the scrolling " +
        "functionality of the paragraph class. This is a long paragraph that is used to test the scrolling ";
    private static final String PATH_TO_TEXTURE = "textures/orc.png";

    private static final List<ParagraphParameters> paragraphs = List.of(
        new ParagraphParameters(SHORT_PARAGRAPH, PATH_TO_TEXTURE),
        new ParagraphParameters(LONG_PARAGRAPH, PATH_TO_TEXTURE)
    );

    public static ParagraphParameters getRandomParagraph() {
        Random random = new Random();
        int randomIndex = random.nextInt(paragraphs.size());
        return paragraphs.get(randomIndex);
    }
}
