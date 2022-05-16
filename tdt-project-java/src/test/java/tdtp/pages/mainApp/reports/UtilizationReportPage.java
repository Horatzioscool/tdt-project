package tdtp.pages.mainApp.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tdtp.pages.mainApp.BasePage;

import java.util.Locale;

public class UtilizationReportPage extends BasePage {
    @FindBy(xpath = "//*[@id='__next']//button/*[text() ='Back to Reports Dashboard']")
    private WebElement backBtn;

    public boolean is_utilizationReportsPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("utilization reports");
    }

    private void waitForPageToLoad() {
        waitForElement(backBtn);
    }
}
