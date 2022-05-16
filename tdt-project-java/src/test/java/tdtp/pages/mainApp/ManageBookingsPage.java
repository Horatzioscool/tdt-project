package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageBookingsPage extends BasePage {

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'ADD NEW BOOKING')]")
    private WebElement addNewBookingBtn;

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'BOOK FOR ANOTHER USER')]")
    private WebElement bookForAnotherUserBtn;

    @FindBy(xpath = "//*[@id='__next']//span[contains(text(), 'VIEW ALL BOOKINGS')]")
    private WebElement viewAllBookingsBtn;


    private void waitForPageToLoad()
    {
        waitForElement(addNewBookingBtn);
        waitForElement(bookForAnotherUserBtn);
        waitForElement(viewAllBookingsBtn);
    }


    public boolean is_BookingsPage() {
        waitForPageToLoad();
        return getPageTitle().contains("Manage bookings");
    }

}
