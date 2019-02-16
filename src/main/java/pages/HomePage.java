package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginMenu;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement signUpButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginMenu));
        return getDriver().getTitle();
    }

    public LoginPage clickLoginMenu() {
        loginMenu.click();
        return new LoginPage(getDriver());
    }

    public SignUpPage clickSignUpButton() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
        return new SignUpPage(getDriver());
    }


}
