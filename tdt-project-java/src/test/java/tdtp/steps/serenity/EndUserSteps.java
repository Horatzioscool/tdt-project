package tdtp.steps.serenity;

import net.thucydides.core.annotations.Step;
import tdtp.pages.AuthPage;
import tdtp.pages.LoginPage;
import tdtp.pages.mainApp.*;
import tdtp.pages.mainApp.reports.DesksReportPage;
import tdtp.pages.mainApp.reports.UserPresenceReportPage;
import tdtp.pages.mainApp.reports.UtilizationReportPage;

import static org.junit.Assert.*;

public class EndUserSteps {
    private AuthPage authPage;
    private LoginPage loginPage;
    private ManageBookingsPage manageBookingsPage;
    private BuildingsPage buildingsPage;
    private UsersPage usersPage;
    private DesksPage desksPage;
    private ReportsPage reportsPage;
    private ContactPage contactPage;
    private BasePage basePage;
    private DesksReportPage desksReportPage;
    private UserPresenceReportPage userPresenceReportPage;
    private UtilizationReportPage utilizationReportPage;


    @Step
    public void open_auth_page() {
        authPage.open();
    }

    @Step
    public void authenticate() {
        String authUsername = "lhdemo";
        String authPassword = "LH@Evozon!2022";
        authPage.authenticate(authUsername, authPassword);
    }

    @Step
    public void login(String username, String password) {
        loginPage.login(username, password);

    }

    @Step
    public void sign_out(){
        basePage.signOut();
    }

    @Step
    public void should_be_on_manageBookings_page() {
        assertTrue("User should be on manage bookings page!", manageBookingsPage.is_BookingsPage());
    }

    @Step
    public void should_be_on_buildings_page() {
        assertTrue("User should be on buildings page!", buildingsPage.is_BuildingsPage());
    }

    @Step
    public void should_be_on_users_page() {
        assertTrue("User should be on users page!", usersPage.is_UsersPage());
    }

    @Step
    public void should_be_on_desks_page() {
        assertTrue("User should be on desks page!", desksPage.is_DesksPage());
    }

    @Step
    public void should_be_on_reports_page() {
        assertTrue("User should be on reports page!", reportsPage.is_ReportsPage());
    }

    @Step
    public void should_be_on_contact_page() {
        assertTrue("User should be on contact page!", contactPage.is_ContactPage());
    }

    @Step
    public void should_be_on_login_page() {
        assertTrue("User should be on contact page!", loginPage.is_loginPage());
    }

    @Step
    public void should_be_on_desks_report_page(){
        assertTrue("User should be on desks report page!", desksReportPage.is_desksReportPage());
    }

    @Step
    public void should_be_on_userPresence_report_page(){
        assertTrue("User should be on users presence report page!", userPresenceReportPage.is_userPresenceReportPage());
    }

    @Step
    public void should_be_on_utilization_report_page(){
        assertTrue("User should be on utilization report page!", utilizationReportPage.is_utilizationReportsPage());
    }

    @Step
    public void select_manageBookingsPage() {
        basePage.clickOnTab("bookings");
    }

    @Step
    public void select_buildingsPage() {
        basePage.clickOnTab("buildings");
    }

    @Step
    public void select_usersPage() {
        basePage.clickOnTab("users");
    }

    @Step
    public void select_desksPage() {
        basePage.clickOnTab("desks");
    }

    @Step
    public void select_reportsPage() {
        basePage.clickOnTab("reports");
    }

    @Step
    public void select_contactPage() {
        basePage.clickOnTab("contact");
    }

    @Step
    public void go_to_desksReportPage() {
        basePage.clickOnTab("reports");
        reportsPage.select_desksReports();
    }
    @Step
    public void go_to_userPresenceReportPage(){
        basePage.clickOnTab("reports");
        reportsPage.select_userPresenceReports();
    }
    @Step
    public void go_to_utilizationReportsPage() {
        basePage.clickOnTab("reports");
        reportsPage.select_utilizationReports();
    }
}
