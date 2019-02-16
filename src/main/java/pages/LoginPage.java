package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id = "exampleInputEmail1")
    WebElement usernameField;

    @FindBy(id = "exampleInputPassword1")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type ='submit' and @class ='btn btn-primary btn-block']")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage clickSubmitButton() {
        submitButton.click();
        return new HomePage(getDriver());
    }

    public String verifyLoginPageTitle() {
        return getDriver().getTitle();
    }

}