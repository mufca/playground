package io.github.mufca.libgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.tommyettinger.textra.TypingLabel;
import io.github.mufca.libgdx.gui.Paragraph;
import io.github.mufca.libgdx.gui.core.CoreTable;
import io.github.mufca.libgdx.temporarytrash.ParagraphConstants;
import io.github.mufca.libgdx.temporarytrash.ParagraphParameters;

import java.util.Arrays;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class Screen extends ApplicationAdapter implements com.badlogic.gdx.Screen {
    private CoreTable innerTable;
    private ScrollPane scrollPane;
    private Stage stage;
    private long startTime;

    @Override
    public void show() {
        startTime = System.currentTimeMillis();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Table outerTable = new Table();
        innerTable = new CoreTable();
        scrollPane = new ScrollPane(innerTable);
        outerTable.setFillParent(true);
        outerTable.add(scrollPane).expand().fill();
        stage.addActor(outerTable);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Paragraph paragraph = new Paragraph(ParagraphConstants.getRandomParagraph());
            innerTable.add(paragraph).expandX().fillX().row();
            removeExcessCell();
            scrollPane.scrollTo(0, 0, 0, 0);
//        }
        if((TimeUtils.timeSinceMillis(startTime) & 1023) < 15)
            System.out.println("Native Heap: " + Gdx.app.getNativeHeap() + "  at time " + TimeUtils.timeSinceMillis(startTime) + " ms");
    }

    private void removeExcessCell() {
        int max_limit = 5;
        if (innerTable.getRows() > max_limit) {
            // logs the identity of the font, is always the same...
//            System.out.println(System.identityHashCode(((Paragraph)innerTable.getChild(0)).typingLabel.getFont()));
//            ((Paragraph)innerTable.getChild(0)).typingLabel.getFont().dispose();
            innerTable.getChild(0).remove();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
