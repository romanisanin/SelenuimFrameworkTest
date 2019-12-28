package navigation;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class naigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void switchToTab(){
        homePage.clickMultipleWindowsPage().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void rigthclickPageOpening(){
        var Example2Page = homePage.clickDynamicLoading().rightClickExample2();
        getWindowManager().switchToTab();
        Assert.assertEquals(Example2Page.getButton(), "Start", "Can not find the Start button");
    }
}
