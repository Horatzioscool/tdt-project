package tdtp.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AuthPage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='__next']//button")
    private WebElement signInBtn;

    private void waitForLoginPageToLoad(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
    }

    public boolean is_loginPage(){
        waitForLoginPageToLoad();
        return usernameField.isDisplayed() && passwordField.isDisplayed() && signInBtn.isDisplayed();
    }

    public void login(String username, String password){
        waitForLoginPageToLoad();
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInBtn.click();

        if(getDriver().findElements(By.xpath("//*[@id=\"__next\"]//h1[contains(text(),'Too many failed attempts.')]")).size() > 0)
        {
            try {
                Thread.sleep(33000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitForLoginPageToLoad();
            usernameField.clear();
            passwordField.clear();

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            signInBtn.click();
        }
    }
}
