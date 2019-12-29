package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.util.List;

public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());

        goHome();
        homePage = new HomePage(driver);
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(375,812));

//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//
//        WebElement inputsLink = driver.findElement(By.linkText("Shifting Content"));
//        inputsLink.click();
//
//        inputsLink = driver.findElement(By.linkText("Example 1: Menu Element"));
//        inputsLink.click();
//
//        WebElement inputsLink2 = driver.findElement(By.tagName("ul"));
//
//        List<WebElement> links1 = inputsLink2.findElements(By.tagName("a"));
//        System.out.println(links1.size());
//
//        System.out.println(driver.getTitle());


    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

//
//    public static void main(String args[]){
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
}

