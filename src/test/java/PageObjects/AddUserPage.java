package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserPage {
    public WebDriver lDriver;
    public WebDriverWait wait;

    public AddUserPage(WebDriver lDriver) {
        this.lDriver = lDriver;
        wait=new WebDriverWait(lDriver, Duration.ofMinutes(5));
        PageFactory.initElements(lDriver, this);
    }

    @FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
    @CacheLookup
    WebElement addBtn;
    @FindBy(xpath = "//input[@ng-reflect-name='firstname']")
    @CacheLookup
    WebElement txtFirstname;
    @FindBy(xpath = "//input[@ng-reflect-name='lastname']")
    @CacheLookup
    WebElement txtLastname;
    @FindBy(xpath = "//input[@ng-reflect-name='cin']")
    @CacheLookup
    WebElement txtCin;
    @FindBy(xpath = "//input[@ng-reflect-name='email']")
    @CacheLookup
    WebElement txtEmail;
    @FindBy(id = "mat-select-value-5")
    WebElement countryDropdown;

    @FindBy(id = "mat-input-5")
    WebElement phoneNumberInput;
    @FindBy(xpath = "//mat-select[@id='mat-select-6']")
    @CacheLookup
    WebElement department;
    @FindBy(xpath = "//mat-select[@id='mat-select-8']")
    @CacheLookup
    WebElement position;
    @FindBy(xpath = "//mat-select[@id='mat-select-10']")
    @CacheLookup
    WebElement role;
    @FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
    @CacheLookup
    WebElement saveBtn;
    @FindBy(id = "mat-error-4")
    @CacheLookup
    WebElement error;
    @FindBy(xpath = "//div[contains(@class, 'mat-select-trigger') and contains(@class, 'ng-tns-c258-7')]")
    @CacheLookup
    WebElement selectDepartment;

    public void setFirstname(String firstname){
        wait.until(ExpectedConditions.visibilityOf(txtFirstname));
        txtFirstname.clear();
        txtFirstname.sendKeys(firstname);
    }
    public void setLastname(String lastname){
        wait.until(ExpectedConditions.visibilityOf(txtLastname));
        txtLastname.clear();
        txtLastname.sendKeys(lastname);
    }
    public void setCin(String cin){
        txtCin.clear();
        txtCin.sendKeys(cin);
    }
    public void setEmail(String email){
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }
    public void setRole(String selectedRole){
        role.click();
        // Select the country from the dropdown options
        try {
            WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//mat-option[contains(., '" + selectedRole + "')]")));
            roleOption.click();
        } catch (NoSuchElementException e) {
            System.out.println("Country option '" + selectedRole + "' not found in dropdown.");
            // Handle exception or log appropriately
        }
    }
    public void setNumber(String selectedCountry, String userNumber) {
        // Wait for the country dropdown to be clickable

        countryDropdown.click();
        // Select the country from the dropdown options
        try {
            WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//mat-option[contains(., '" + selectedCountry + "')]")));
            countryOption.click();
        } catch (NoSuchElementException e) {
            System.out.println("Country option '" + selectedCountry + "' not found in dropdown.");
            // Handle exception or log appropriately
        }

        // Enter userNumber in phoneNumberInput field
        phoneNumberInput.sendKeys(userNumber);
    }
    public void setPosition(String selectedPosition){
        position.click();
        // Select the country from the dropdown options
        try {
            WebElement positionOption = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//mat-option[contains(., '" + selectedPosition + "')]")));
            positionOption.click();
        } catch (NoSuchElementException e) {
            System.out.println("Country option '" + selectedPosition + "' not found in dropdown.");
            // Handle exception or log appropriately
        }
    }
    public void clickAdd(){
        wait.until(ExpectedConditions.visibilityOf(addBtn));
        addBtn.click();
    }
    public void setDepartment(String selectedDepartment){
        department.click();
        // Select the country from the dropdown options
        try {
            WebElement departmentOption = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//mat-option[contains(., '" + selectedDepartment + "')]")));
            departmentOption.click();
        } catch (NoSuchElementException e) {
            System.out.println("Country option '" + selectedDepartment + "' not found in dropdown.");
            // Handle exception or log appropriately
        }
    }
    public void clickSave(){
        saveBtn.click();
    }
    public void selectDepartment(String selectedDepartment){
        selectDepartment.click();
        // Select the country from the dropdown options
        try {
            WebElement departmentOption = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//mat-option[contains(., '" + selectedDepartment + "')]")));
            departmentOption.click();
        } catch (NoSuchElementException e) {
            System.out.println("Country option '" + selectedDepartment + "' not found in dropdown.");
            // Handle exception or log appropriately
        }

    }








}
