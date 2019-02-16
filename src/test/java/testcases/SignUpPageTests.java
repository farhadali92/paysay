package testcases;

import constants.Constants;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.PropertiesUtils;

public class SignUpPageTests {

    PropertiesUtils propertiesUtils;
    WebDriver webDriver;
    HomePage homePage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() throws Exception {
        PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();
        String browser = propertiesUtils.get("browser");
        webDriver = WebDriverFactory.getWebDriver(browser);
        webDriver.get(propertiesUtils.get("url"));
        homePage = new HomePage(webDriver);
        signUpPage = homePage.clickSignUpButton();
    }

    @Test
    public void verifySignUpPageTitle() {
        Assert.assertEquals(signUpPage.getSignUpPageTitle(), Constants.SIGNUP_PAGE_TITLE);
    }

    @Test
    public void enterSignUpDetails() {
        signUpPage.enterSignUpDetails("test@gmail.com", "baqwas");

    }


    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

