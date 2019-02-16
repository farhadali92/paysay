package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends AbstractPage {

    @FindBy(id = "exampleInputEmail1")
    WebElement signUpEmailAddress;

    @FindBy(id = "password")
    WebElement signUpPassword;

    @FindBy(id = "confirm_password")
    WebElement signUpConfirmPassword;

    @FindBy(xpath = "//button[@type ='submit']")
    WebElement signUpButton;


    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSignUpPageTitle(){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signUpEmailAddress));
        return getDriver().getTitle();

    }

    public void enterSignUpDetails(String email, String password){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signUpEmailAddress));
        signUpEmailAddress.sendKeys(email);
        signUpPassword.sendKeys(password);
        signUpConfirmPassword.sendKeys(password);
        //signUpButton.click();

    }



}