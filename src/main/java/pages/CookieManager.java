package pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookieManager {
    private WebDriver driver;

    public CookieManager(WebDriver driver){
        this.driver = driver;
    }

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public Set<Cookie> getCookiesList(){
        Set<Cookie> set = driver.manage().getCookies();
        return set;
    }

    /**
     *
     * @param cookie
     * @return true if doesn't exist
     */
    public Boolean getCookie(String cookie){
        if (driver.manage().getCookieNamed(cookie) == null){
            return true;
        }
        return false;
    }

    public void deleteCookie(String cookie){
        driver.manage().deleteCookie(driver.manage().getCookieNamed(cookie));
    }

    private Cookie buildCookie(String name, String value){
        Cookie cookie = new Cookie.Builder(name, value)
                .domain("the-internet.herokuapp.com")
                .build();
        return cookie;
    }
}
