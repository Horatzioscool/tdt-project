package tdtp.pages.mainApp;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends PageObject {

    @FindBy(xpath = "//*[@id='__next']//span[text() = 'MANAGE BOOKINGS']")
    private WebElement manageBookingsTab;

    @FindBy(xpath = "//*[@id='__next']//span[text() = 'BUILDINGS']")
    private WebElement buildingsTab;

    @FindBy(xpath = "//*[@id='__next']//span[text() = 'USERS']")
    private WebElement usersTab;

    @FindBy(xpath = "//*[@id='__next']//span[text() = 'DESKS']")
    private WebElement desksTab;

    @FindBy(xpath = "//*[@id='__next']//span[text() = 'REPORTS']")
    private WebElement reportsTab;

    @FindBy(xpath = "//*[@id='__next']//span[text() = 'CONTACT']")
    private WebElement contactTab;

    @FindBy(xpath = "//*[@id=\"__next\"]//h6/strong")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id='__next']//img[@alt='profile']")
    private WebElement profileBtn;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/div[3]/ul/li[2]")
    private WebElement signOutBtn;

    public void clickOnTab(String tabName)
    {

        switch (tabName)
        {
            case "bookings":
                waitForElement(manageBookingsTab);
                manageBookingsTab.click();
                break;
            case "buildings":
                waitForElement(buildingsTab);
                buildingsTab.click();
                break;
            case "users":
                waitForElement(usersTab);
                usersTab.click();
                break;
            case "desks":
                waitForElement(desksTab);
                desksTab.click();
                break;
            case "reports":
                waitForElement(reportsTab);
                reportsTab.click();
                break;
            case "contact":
                waitForElement(contactTab);
                contactTab.click();
                break;
        }
    }

    public void waitForElement(WebElement e){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void signOut(){
        waitForElement(profileBtn);
        profileBtn.click();
        waitForElement(signOutBtn);
        signOutBtn.click();
    }

}
