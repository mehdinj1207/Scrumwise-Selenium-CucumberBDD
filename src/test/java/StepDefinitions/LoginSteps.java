package StepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    public WebDriver webDriver;
    public LoginPage loginPage;
    @Given("User launchs chrome browser")
    public void user_launchs_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","E://chromedriver-win64/chromedriver.exe");
        webDriver= new ChromeDriver();
        loginPage=new LoginPage(webDriver);
    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        webDriver.get(url);
    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String username, String password) {
        loginPage.setUserName(username);
        loginPage.setPassword(password);
    }
    @When("Click on Login")
    public void click_on_login() {
        loginPage.clickBtnLogin();
    }

    @When("user clicks on Log out")
    public void user_clicks_on_log_out() throws InterruptedException {
        loginPage.clickBtnLogout();
        Thread.sleep(3000);
    }
    @Then("Title should be {string}")
    public void title_should_be(String title) {
        if(webDriver.getTitle()=="scrumwise"){
            Assert.assertTrue(false);
        }
        else {
            Assert.assertEquals(title,webDriver.getTitle());
        }

    }
    @Then("I close browser")
    public void i_close_browser() {
        webDriver.quit();
    }
}
