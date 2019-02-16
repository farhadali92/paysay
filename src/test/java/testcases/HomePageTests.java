package testcases;

import constants.Constants;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.PropertiesUtils;

public class HomePageTests {

    PropertiesUtils propertiesUtils;
    WebDriver webDriver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() throws Exception {
        propertiesUtils = PropertiesUtils.getInstance();
        String browser = propertiesUtils.get("browser");
        webDriver = WebDriverFactory.getWebDriver(browser);
        webDriver.get(propertiesUtils.get("url"));
        homePage = new HomePage(webDriver);
    }

    @Test
    public void verifyHomePageTitle() {
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }


    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
