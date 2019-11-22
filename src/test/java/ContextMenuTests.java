import alerts.AlertTests;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.contextMenuOpen();
        Assert.assertEquals(contextMenuPage.alert_getText(), "You selected a context menu", "Alert has different message");
        contextMenuPage.alert_clickToAccept();
    }

}
