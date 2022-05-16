package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class DesksPage extends BasePage{

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'ADD NEW DESK')]")
    private WebElement addNewDeskBtn;

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'MANAGE EQUIPMENT LIST')]")
    private WebElement manageEquipmentListBtn;

    private void waitForPageToLoad()
    {
        waitForElement(addNewDeskBtn);
        waitForElement(manageEquipmentListBtn);
    }

    public boolean is_DesksPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("desks");
    }
}
