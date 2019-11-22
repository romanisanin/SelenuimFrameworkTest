package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ContextMenuPage {
    private WebDriver driver;
    private By hotSpotBlock = By.id("hot-spot");
    private By triggerAlertButton = By.xpath(".//button[text()='You selected a context menu']");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void contextMenuOpen(){
        Actions actions = new Actions(driver);
        WebElement hotSpotElement = driver.findElement(hotSpotBlock);
        actions.contextClick(hotSpotElement).perform();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
}
