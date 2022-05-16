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
        System.out.println(getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl().equalsIgnoreCase("https://lhdemo:LH%40Evozon%212022@lighthouse-demo.evozon.com/contact-us");
    }
}
