package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTests {

    @Test
    public void testAccertAlert(){
        var alertPage = homePage.clickJSAlerts();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        Assert.assertEquals(alertPage.getResult(), "You successfuly clicked an alert", "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJSAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        Assert.assertEquals(text, "I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJSAlerts();
        alertsPage.triggerPrompt();
        String text = "Selenium Rulit!";

        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResult(), "You entered: " + text,"Result text incorrect");
    }
}
