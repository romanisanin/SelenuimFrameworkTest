package CookiesTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesTests extends BaseTests {

    @Test
    public void deleteCookieAndVerify(){
        var CookieCheck = homePage.cookieOptions();
        if (!CookieCheck.getCookie("optimizelyBuckets")){
            CookieCheck.deleteCookie("optimizelyBuckets");
        }
        Assert.assertTrue(CookieCheck.getCookie("optimizelyBuckets"), "Cookie was not deleted");
    }
}
