package tdtp.quickTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tdtp.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class QuickTests {

    private String username = "gomicox775@roxoas.com", password = "Pass.1234";


    @Managed(uniqueSession = false)
    public WebDriver webDriver;

    @Before
    public void initializeDriver(){
        webDriver.manage().window().maximize();
    }

    @Steps
    public EndUserSteps user;

    @Test
    public void loginPage_loads_after_authentication() {
        //Given that auth page is open
        user.open_auth_page();
        //When user authenticates
        user.authenticate();
        //Then login page should be prompted
        user.should_be_on_login_page();
    }

    @Test
    public void manageBookingsPage_loads_after_login() {
        //Given that the user is on the login page
        user.open_auth_page();
        user.authenticate();
        //When the user successfully logs in
        user.login(username, password);
        //Then the manage bookings page should be prompted
        user.should_be_on_manageBookings_page();
    }

    @Test
    public void manageBookingsPage_loads_after_selection() {
        //Given that the user is logged in
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        //When the user selects the manage bookings page
        user.select_manageBookingsPage();
        //Then the manage bookings Page should be prompted
        user.should_be_on_manageBookings_page();
    }

    @Test
    public void buildingsPage_loads_after_selection() {
        //Given that the user is logged in
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        //When the user selects the buildings page
        user.select_buildingsPage();
        //Then the buildings page should be prompted
        user.should_be_on_buildings_page();
    }

    @Test
    public void usersPage_loads_after_selection() {
        //Given that the user is logged in
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        //When the user selects the user page
        user.select_usersPage();
        //Then the users page should be prompted
        user.should_be_on_users_page();
    }

    @Test
    public void desksPage_loads_after_selection() {
        //Given that the user is logged in
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        //When the user selects the desks page
        user.select_desksPage();
        //Then the desks page should be prompted
        user.should_be_on_desks_page();
    }

    @Test
    public void reportsPage_loads_after_selection() {
        //Given that the user is logged in
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        //When the user selects the reports page
        user.select_reportsPage();
        //Then the reports page should be prompted
        user.should_be_on_reports_page();
    }

    @Test
    public void contactPage_loads_after_selection() {
        //Given that the user is logged in
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        //When the user selects the contact page
        user.select_contactPage();
        //Then the contact page should be prompted
        user.should_be_on_contact_page();
    }

    @After
    public void clear(){
        user.sign_out();
    }

}
