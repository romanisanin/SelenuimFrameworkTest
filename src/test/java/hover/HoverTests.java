package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUSer1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.HoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link incorrect");
        assertTrue(caption.getLink().endsWith("users/1"), "Link incorrect");
    }
}
