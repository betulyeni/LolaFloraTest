package LolaFloraTest.steps;

import LolaFloraTest.pages.DashBoardPage;
import LolaFloraTest.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Severity(SeverityLevel.CRITICAL)
@Feature("Title Feature Check")
@Epic("Title Epic Check")
public class LoginTitle {

    private final LoginPage loginPage;
    private final DashBoardPage dashBoardPage;
    private final Logger logger;

    public LoginTitle() {
        WebDriver driver = StepHooks.driver;
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        logger = Logger.getLogger("Sign In Title");
    }

    @Then("User see {string} title on the page")
    @Severity(SeverityLevel.BLOCKER)
    public void user_see_title_on_the_page(String title) {
        logger.info("Check whether 'Sign In' title exists");
        assertEquals(title , loginPage.getHeadingOfLoginPage());
    }

}
