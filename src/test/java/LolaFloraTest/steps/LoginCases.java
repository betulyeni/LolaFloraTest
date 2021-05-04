package LolaFloraTest.steps;


import LolaFloraTest.pages.DashBoardPage;
import LolaFloraTest.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginCases {

    private final LoginPage loginPage;
    private final DashBoardPage dashBoardPage;
    private final Logger logger;

    public LoginCases(){
        WebDriver driver = StepHooks.driver;
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        logger = Logger.getLogger("Login");
    }

    @Description("Navigating to login page")
    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
        logger.info("Navigating to the login page");
        loginPage.navigateToLoginPage();
    }

    @Description("User expects to see ' {0} ' on the Dashboard")
    @Then("^User see \"([^\"]*)\" title on the Dashboard$")
    public void user_see_title_on_the_Dashboard(String title) {
        logger.info("Check the title on the Dashboard");
        assertEquals(title, dashBoardPage.getMenuTitle());
    }

    @Description("User enters email: {0} and password: {1}")
    @When("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.doLogin(email,password);
    }

    @Description("User expects to see ' {0} ' validation message")
    @Then("User see message {string} under email input area")
    public void user_see_message_under_email_input_area(String message) {
        assertEquals(message, loginPage.getEmailValidationMessage());
    }

    @Description("User expects to see ' {0} ' validation message")
    @Then("User see message {string} under password input area")
    public void user_see_message_under_password_input_area(String message) {
        assertEquals(message, loginPage.getPasswordValidationMessage());
    }

    @Description("User expects to see ' {0} ' popup message")
    @Then("User see message {string} in a new popup")
    public void user_see_message_in_a_new_popup(String message) {
        assertEquals(message, loginPage.getPopupMessage());
    }
}
