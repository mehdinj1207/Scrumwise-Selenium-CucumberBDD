package StepDefinitions;

import PageObjects.AddUserPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    public WebDriver webDriver;
    public LoginPage loginPage;
    public AddUserPage addUserPage;
    @Given("User launchs chrome browser")
    public void user_launchs_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","E://chromedriver-win64/chromedriver.exe");
        webDriver= new ChromeDriver();
        loginPage=new LoginPage(webDriver);
        addUserPage= new AddUserPage(webDriver);

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
            assertTrue(false);
        }
        else {
            Assert.assertEquals(title,webDriver.getTitle());
        }

    }


    @When("User clicks on Add new user button")
    public void user_clicks_on_add_new_user_button() {
       addUserPage.clickAdd();
    }


    @When("User enters customer info")
    public void user_enters_customer_info() {
        addUserPage.setFirstname("Aziz");
        addUserPage.setLastname("Hmed");
        addUserPage.setCin("14009219");
        addUserPage.setEmail("aziz.hmed.hedi@talan.com");
        addUserPage.setNumber("France","562356326");
        addUserPage.setDepartment("Java");
        addUserPage.setPosition("Software Engineer");
        addUserPage.setRole("Consultant");
    }
    @When("Click on save button")
    public void click_on_save_button() {
        addUserPage.clickSave();
    }
    @Then("User can see the home page again")
    public void user_can_see_the_home_page_again() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        // Find the element with the text "Welcome back, Mehdi!"
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'text-2xl') and contains(text(), 'Welcome back, Mehdi!')]")));

        // Assert that the text is present
        assertTrue("Welcome message is not displayed", welcomeMessage.isDisplayed());
    }
    @When("User go to the department of the new user")
    public void user_go_to_the_department_of_the_new_user() {
        addUserPage.selectDepartment("Java");
    }
    @Then("User can see the new ly added user in the list")
    public void user_can_see_the_new_ly_added_user_in_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I close browser")
    public void i_close_browser() {
        webDriver.quit();
    }

}
