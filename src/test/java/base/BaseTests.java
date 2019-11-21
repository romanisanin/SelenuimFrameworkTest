package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.List;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
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

//
//    public static void main(String args[]){
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
}

