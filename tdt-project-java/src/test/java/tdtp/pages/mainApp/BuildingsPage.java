package tdtp.pages.mainApp;

import org.mockito.internal.matchers.Find;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class BuildingsPage extends BasePage{
    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'ADD NEW BUILDING')]")
    private WebElement addNewBuildingBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/button/span[1]")
    private WebElement buildingsPageBtn;

    @FindBy(xpath = "//*[@id=\"label\"]")
    private WebElement buildingNameInput;

    @FindBy(xpath = "//*[@id=\"safeDistance\"]")
    private WebElement safeDistanceInput;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div[4]/div/div[2]")
    private WebElement saveNewBuildingBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div/div[1]/table/tbody/tr[7]/td[4]/div/button/span[1]/svg")
    private WebElement buildingActionsIndex7;

    @FindBy(xpath = "//*[@id=\"long-menu\"]/div[3]/ul/li[2]")
    private WebElement deleteBuildingBtn;

    @FindBy(xpath = "//*[@id=\"long-menu\"]/div[3]/ul/li[1]")
    private WebElement editBuildingsBtn;

    @FindBy(xpath = "//*[@id=\"label\"]")
    private WebElement editBuildingNameInput;

    @FindBy(xpath = "//*[@id=\"safeDistance\"]")
    private WebElement editBuildingsSafeDistance;

    @FindBy(xpath = "/html/body/div[15]/div[3]/div/div[2]/div/div[4]/div/div/button/span[1]")
    private WebElement saveEditedBuildingBtn;

    private void waitForPageToLoad()
    {
        waitForElement(addNewBuildingBtn);
    }

    public void set_addNewBuildingBtn() {
        waitForElement(addNewBuildingBtn);
        addNewBuildingBtn.click();
    }

    public void goToBuildingsPage() {
        waitForElement(buildingsPageBtn);
        buildingsPageBtn.click();
    }

    public void set_buildingName(String name) {
        waitForElement(buildingNameInput);
        buildingNameInput.sendKeys(name);
    }

    public void set_safeDistance(String dist) {
        waitForElement(safeDistanceInput);
        safeDistanceInput.sendKeys(dist);
    }

    public void createNewBuilding() {
        waitForElement(saveNewBuildingBtn);
        saveNewBuildingBtn.click();
    }

    public void select_buildingActionsIndex7() {
        waitForElement(buildingActionsIndex7);
        buildingActionsIndex7.click();
    }

    public void select_deleteBuilding() {
        waitForElement(deleteBuildingBtn);
        deleteBuildingBtn.click();
    }

    public void select_editBuilding() {
        waitForElement(editBuildingsBtn);
        editBuildingsBtn.click();
    }

    public void set_editBuildingsName() {
        waitForElement(editBuildingNameInput);
        editBuildingNameInput.sendKeys("edited-name");
    }

    public void set_editBuildingsSafeDistance() {
        waitForElement(editBuildingsSafeDistance);
        editBuildingsSafeDistance.sendKeys("25");
    }

    public void select_saveEditedBuilding() {
        waitForElement(saveEditedBuildingBtn);
        saveEditedBuildingBtn.click();
    }

    public void waitForElement(WebElement e){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public boolean is_BuildingsPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("buildings");
    }
}
