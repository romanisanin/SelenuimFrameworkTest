package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFrames {
    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By body = By.tagName("body");

    public NestedFrames(WebDriver driver){
        this.driver = driver;
    }

    private void switchToTheMainArea(){
        driver.switchTo().defaultContent();
    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = driver.findElement(body).getText();
        switchToTheMainArea();
        return text;
    }
    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = driver.findElement(body).getText();
        switchToTheMainArea();
        return text;
    }
}
