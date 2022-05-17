package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageBookingsPage extends BasePage {

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'ADD NEW BOOKING')]")
    private WebElement addNewBookingBtn;

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'BOOK FOR ANOTHER USER')]")
    private WebElement bookForAnotherUserBtn;

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'VIEW ALL BOOKINGS')]")
    private WebElement viewAllBookingsBtn;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div/button/span[1]/div")
    private WebElement deleteLastUpcomingBookingBtn;

    @FindBy(xpath = "//*[@id=\"users\"]")
    private WebElement anotherUserMailInput;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div[3]/div/button/span[1]")
    private WebElement selectAnotherUserMailBtn;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[4]/div[4]/div")
    WebElement datePickerDateSelection;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[4]/div/div[1]/div/div/div")
    WebElement areaPicker;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[4]")
    WebElement areaListItem;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/div[2]/div/div/div[3]/div/div/div/div[2]/div[11]/div/div/div[3]")
    WebElement emptyDeskSelection;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'BOOK DESK')]")
    WebElement bookDeskButton;

    public void select_datePickerDate() {
        waitForElement(datePickerDateSelection);
        datePickerDateSelection.click();
    }

    public void select_areaPickerArea() {
        areaPicker.click();
        waitForElement(areaListItem);
        areaListItem.click();
    }

    public void select_emptyDesk() {
        waitForElement(emptyDeskSelection);
        emptyDeskSelection.click();
    }

    public void finish_deskBooking() {
        waitForElement(bookDeskButton);
        bookDeskButton.click();
    }

    public void waitForElement(WebElement e){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    private void waitForPageToLoad()
    {
        waitForElement(addNewBookingBtn);
        waitForElement(bookForAnotherUserBtn);
        waitForElement(viewAllBookingsBtn);
    }

    public void select_bookForAnotherUserBtn() {
        waitForElement(bookForAnotherUserBtn);
        bookForAnotherUserBtn.click();
    }

    public void set_anotherUserMailInput(String mail) {
        waitForElement(anotherUserMailInput);
        anotherUserMailInput.sendKeys(mail);
    }

    public void select_selectAnotherUserMailBtn() {
        waitForElement(selectAnotherUserMailBtn);
        selectAnotherUserMailBtn.click();
    }

    public void select_addNewBookingBtn() {
        addNewBookingBtn.click();
    }

    public void delete_firstElementOfUpcomingBookings() {
        waitForElement(addNewBookingBtn);
        deleteLastUpcomingBookingBtn.click();
    }

    public boolean is_BookingsPage() {
        waitForPageToLoad();
        return getPageTitle().contains("Manage bookings");
    }

}
