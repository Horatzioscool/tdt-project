package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
    @FindBy(name = "subject")
    private WebElement subjectField;

    @FindBy(name = "description")
    private WebElement descriptionField;

    private void waitForPageToLoad()
    {
        waitForElement(subjectField);
        waitForElement(descriptionField);
    }

    public boolean is_ContactPage() {
        return getDriver().getCurrentUrl().equalsIgnoreCase("https://lighthouse-demo.evozon.com/contact-us");
    }
}
