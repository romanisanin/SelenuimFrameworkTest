package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\roman\\Projects\\Selenium\\HerokuApp\\resources\\chromedriver.exe");
        Assert.assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded failed");
    }
}
