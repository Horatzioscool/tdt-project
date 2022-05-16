package tdtp.steps.serenity;

import net.thucydides.core.annotations.Step;
import tdtp.pages.AuthPage;
import tdtp.pages.LoginPage;
import tdtp.pages.mainApp.*;

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
}
