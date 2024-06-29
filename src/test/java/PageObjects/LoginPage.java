package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver lDriver;
    public WebDriverWait wait;

    public LoginPage(WebDriver lDriver) {
        this.lDriver = lDriver;
        wait=new WebDriverWait(lDriver, Duration.ofMinutes(5));
        PageFactory.initElements(lDriver, this);
    }
    @FindBy(id="username")
    @CacheLookup
    WebElement txtEmail;
    @FindBy(id="password")
    @CacheLookup
    WebElement txtPassword;
    @FindBy(id="kc-login")
    @CacheLookup
    WebElement btnLogin;
    @FindBy(xpath = "//button[contains(@class, 'mat-focus-indicator') and contains(@class, 'mat-menu-trigger') and contains(@class, 'mat-icon-button') and contains(@class, 'mat-button-base') and contains(@class, 'cdk-focused') and contains(@class, 'cdk-mouse-focused')]")
    @CacheLookup
    WebElement btnMenu;
    @FindBy(xpath = "(//button[@role='menuitem'])[5]")
    @CacheLookup
    WebElement btnLogout;
    public void setUserName(String username){
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.clear();
        txtEmail.sendKeys(username);
    }
    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    public void clickBtnLogin(){
        btnLogin.click();
    }
    public void clickBtnLogout(){
        wait.until(ExpectedConditions.visibilityOf(btnMenu));
        btnMenu.click();
        btnLogout.click();
    }




}


