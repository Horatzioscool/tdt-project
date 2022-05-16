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
        return getDriver().findElement(By.xpath("//*[@id='__next']//img[@src = 'blob:https://lighthouse-demo.evozon.com/38f0db63-18d5-45ab-a5fa-6ff7bee1e9e4']")).isDisplayed();
    }

    public void login(String username, String password){
        waitForLoginPageToLoad();
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInBtn.click();
    }
}
