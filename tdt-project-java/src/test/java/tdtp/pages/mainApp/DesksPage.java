package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;
import java.util.Locale;

public class DesksPage extends BasePage{

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'ADD NEW DESK')]")
    private WebElement addNewDeskBtn;

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'MANAGE EQUIPMENT LIST')]")
    private WebElement manageEquipmentListBtn;

    @FindBy(xpath = "//*[@id=\"mapWrapper\"]/div[2]/div/canvas[2]")
    private WebElement deskCanvas;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div[2]/div/form/div[2]/div/input")
    private WebElement newDeskPopUpLabelInput;

    @FindBy(xpath = "//*[@id=\"users\"]")
    private WebElement newDeskPopUpAssignToInput;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div[3]/div/button/span[1]")
    private WebElement saveNewDeskBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[2]/div/div[1]/div/div/input")
    private WebElement newEquipmentNameInput;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[2]/div/div[1]/button/span[1]/strong")
    private WebElement newEquipmentCreateBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement editEquipmentHiddenBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/div/input")
    private WebElement editEquipmentNameInput;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/button/span[1]")
    private WebElement saveEditedEquipmentName;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/button/span[1]/svg")
    private WebElement deleteEquipmentBtn;

    private void waitForPageToLoad()
    {
        waitForElement(addNewDeskBtn);
        waitForElement(manageEquipmentListBtn);
    }

    public void select_manageEquipmentListBtn() {
        manageEquipmentListBtn.click();
    }

    public void select_addNewDeskBtn() {
        addNewDeskBtn.click();
    }

    public boolean is_DesksPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("desks");
    }

    public void select_deskCanvas() {
        waitForElement(deskCanvas);
        deskCanvas.click();
    }

    public void set_newDeskPupUpLabelInput(String label) {
        waitForElement(newDeskPopUpLabelInput);
        newDeskPopUpLabelInput.sendKeys(label);
    }

    public void select_saveNewDeskBtn() {
        waitForElement(saveNewDeskBtn);
        saveNewDeskBtn.click();
    }

    public void set_newEquipmentNameInput(String name) {
        waitForElement(newEquipmentNameInput);
        newEquipmentNameInput.sendKeys(name);
    }

    public void select_newEquipmentCreateBtn() {
        waitForElement(newEquipmentCreateBtn);
        newEquipmentCreateBtn.click();
    }

    public void set_editEquipmentNameInput(String newName) {
        waitForElement(editEquipmentNameInput);
        editEquipmentNameInput.sendKeys((newName));
    }

    public void select_editEquipmentHiddenBtn() {
        waitForElement(editEquipmentHiddenBtn);
        editEquipmentHiddenBtn.click();
    }

    public void select_saveEditedEquipmentName() {
        waitForElement(saveEditedEquipmentName);
        saveEditedEquipmentName.click();
    }

    public void select_deleteEquipmentBtn() {
        waitForElement(deleteEquipmentBtn);
        deleteEquipmentBtn.click();
    }

    public void set_newDeskPopUpAssignToInput(String assignTo) {
        waitForElement(newDeskPopUpAssignToInput);
        newDeskPopUpAssignToInput.sendKeys(assignTo);
    }
}
