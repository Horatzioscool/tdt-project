package tdtp.features.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class Login {

    private String username = "gomicox775@roxoas.com", password = "Pass.1234";

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public EndUserSteps user;

    @Test
    public void login_with_valid_data() {
        //Given that the user is authorized
        user.open_auth_page();
        user.authenticate();
        //When he/she tries to login
        user.login(username, password);
        //Then user should see the main page
        user.should_be_on_manageBookings_page();
    }


}
