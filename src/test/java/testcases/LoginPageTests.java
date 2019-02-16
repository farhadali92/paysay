package testcases;

import constants.Constants;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertiesUtils;

public class LoginPageTests {

    PropertiesUtils propertiesUtils;
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @BeforeMethod
    public void setUp() throws Exception {
        propertiesUtils = PropertiesUtils.getInstance();
        String browser = propertiesUtils.get("browser");
        driver = WebDriverFactory.getWebDriver(browser);
        driver.get(propertiesUtils.get("url"));
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePageTitle(){
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
