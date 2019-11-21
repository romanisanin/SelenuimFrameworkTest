package slider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class SliderTests extends BaseTests{
    @Test
    public void testSliderMove(){
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.moveSlider(8);
        Assert.assertEquals(sliderPage.getResults(), "4");
    }

}
