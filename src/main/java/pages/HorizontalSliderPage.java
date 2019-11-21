package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.tagName("input");
    private By result = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param steps starts from 1
     */
    public void moveSlider(Integer steps){
        int x = 1;
        while(x <= steps){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
            x++;
        }
    }

    public String getResults(){
        return driver.findElement(result).getText();
    }
}
