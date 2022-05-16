package tdtp.pages.mainApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class ReportsPage extends BasePage{

    @FindBy(xpath = "//*[@id='__next']//p/strong[contains(text(),'DESKS')]")
    private WebElement desksReportBtn;

    @FindBy(xpath = "//*[@id='__next']//p/strong[contains(text(),'USER PRESENCE')]")
    private WebElement userPresenceReportBtn;

    @FindBy(xpath = "//*[@id='__next']//p/strong[contains(text(),'UTILIZATION')]")
    private WebElement utilizationReportBtn;

    private void waitForPageToLoad()
    {
        waitForElement(desksReportBtn);
        waitForElement(userPresenceReportBtn);
        waitForElement(utilizationReportBtn);
    }


    public boolean is_ReportsPage() {
        waitForPageToLoad();
        return getPageTitle().toLowerCase(Locale.ROOT).contains("reports");
    }

    public void select_desksReports(){
        waitForElement(desksReportBtn);
        desksReportBtn.click();
    }

    public  void select_userPresenceReports(){
        waitForElement(userPresenceReportBtn);
        userPresenceReportBtn.click();
    }

    public void select_utilizationReports(){
        waitForElement(utilizationReportBtn);
        utilizationReportBtn.click();
    }
}
