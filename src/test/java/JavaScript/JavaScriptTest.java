package JavaScript;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTest extends BaseTests {
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    @Test
    public void selectMultipleOptionsDropdownList(){
        var DropdownPage = homePage.clickDropdown();
        List<String> options = new ArrayList<>();
        options.add("Option 1");
        options.add("Option 2");
        DropdownPage.switchDropdownToMultipleSelection();
        for (String option:options) {
            DropdownPage.selectFromDropdown(option);
        }
        var selectedOptions = DropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),options.size(), "number of selected items");
        assertTrue(selectedOptions.containsAll(options),"All Options were Not Selected");
    }

}
