package LolaFloraTest.pages;


import LolaFloraTest.core.Base;
import LolaFloraTest.core.PropKey;
import LolaFloraTest.core.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends Base {

    @FindBy(className = "login__heading")
    private WebElement heading;

    @FindBy(id = "EmailLogin")
    private WebElement emailInputField;

    @FindBy(id = "Password")
    private WebElement passwordInputField;

    @FindBy(css = "#userLogin > div:nth-child(6) > button")
    private WebElement signInButton;

    @FindBy(id = "EmailLogin-error")
    private WebElement emailValidationMessage;

    @FindBy(id = "Password-error")
    private WebElement passwordValidationMessage;

    @FindBy(className = "modal-body")
    private WebElement popupMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailValidationMessage() {
        return elementWaitVisible(emailValidationMessage).getText();
    }

    public String getPasswordValidationMessage() {
        return elementWaitVisible(passwordValidationMessage).getText();
    }

    public String getPopupMessage() {
        return elementWaitVisible(popupMessage).getText();
    }

    public void navigateToLoginPage() throws IOException {
        driver.get(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal()));
    }

    public String getHeadingOfLoginPage() {
        return elementWaitVisible(heading).getText();
    }

    public void doLogin(String email, String password){
        elementWaitClickable(emailInputField).sendKeys(email);
        passwordInputField.sendKeys(password);
        signInButton.click();
    }
}