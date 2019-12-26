package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTests {
    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);
        Assert.assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Text from text editor is incorrect");
    }

    @Test
    public void testNestedFrames(){
        var framePage = homePage.clickFramesPage();
        var nestedFramesPage = framePage.clickNestedLink();
        Assert.assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Text in the left frame doesn't match");
        Assert.assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Text in the bottom frame doesn't match");
    }
}
