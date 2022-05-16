package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class BuildingsPage extends BasePage{
    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'ADD NEW BUILDING')]")
    private WebElement addNewBuildingBtn;

    private void waitForPageToLoad()
    {
        waitForElement(addNewBuildingBtn);
     }

    public boolean is_BuildingsPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("buildings");
    }
}
