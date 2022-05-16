package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class UsersPage extends BasePage{

    @FindBy(id = "mui-component-select-disabled")
    private WebElement userTypeSelect;

    @FindBy(id = "mui-component-select-building")
    private WebElement buildingSelect;

    @FindBy(id = "mui-component-select-floor")
    private WebElement floorSelect;

    @FindBy(name = "setSearchKey")
    private WebElement searchBar;

    private void waitForPageToLoad()
    {
        waitForElement(userTypeSelect);
        waitForElement(buildingSelect);
        waitForElement(floorSelect);
        waitForElement(searchBar);
    }

    public boolean is_UsersPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("users");
    }
}
