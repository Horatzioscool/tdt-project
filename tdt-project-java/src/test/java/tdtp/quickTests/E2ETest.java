package tdtp.quickTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class E2ETest {

    private String username = "zimand33@gmail.com", password = "Zimboy1981";
    private String usernameAdmin = "zimand3@gmail.com", passwordAdmin = "ubbZDIM1981";

    @Managed(uniqueSession = false)
    public WebDriver webDriver;

    @Before
    public void initializeDriver() {
        webDriver.manage().window().maximize();
    }

    @Steps
    public EndUserSteps user;

    @Test
    public void user_desk_booking() {
        user.open_auth_page();
        user.authenticate();
        user.login(username, password);
        user.select_addNewBookingBtn();
        user.select_datePickerDate();
        user.select_areaPickerArea();
        user.select_emptyDesk();
        user.finish_deskBooking();
        user.delete_firstElementOfUpcomingBookings();
        user.sign_out();
    }

    @Test
    public void admin_testing() {
        user.open_auth_page();
        user.authenticate();
        user.login(usernameAdmin, passwordAdmin);
        user.goToBuildingsPage();
        user.set_addNewBuildingBtn();
        user.set_buildingName("new-test-building-xd");
        user.set_safeDistance("567");
        user.createNewBuilding();
        user.select_buildingActionsIndex7();
        user.select_editBuilding();
        user.set_editBuildingsName();
        user.set_editBuildingsSafeDistance();
        user.select_saveEditedBuilding();
        user.select_buildingActionsIndex7();
        user.select_deleteBuilding();
        user.select_desksPage();
        user.select_addNewDeskBtn();
        user.select_deskCanvas();
        user.set_newDeskPupUpLabelInput("newest-desk-who-dat");
        user.set_newDeskPopUpAssignToInput(username);
        user.select_saveNewDeskBtn();
        user.select_manageEquipmentListBtn();
        user.set_newEquipmentNameInput("newest-equipment-who-dat");
        user.select_newEquipmentCreateBtn();
        user.select_editEquipmentHiddenBtn();
        user.set_editEquipmentNameInput("newest-equipment-who-dat-renamed");
        user.select_saveEditedEquipmentName();
        user.set_newEquipmentNameInput("newest-equipment-who-dat-renamed");
        user.select_deleteEquipmentBtn();

        user.select_manageBookingsPage();
        user.select_bookForAnotherUserBtn();
        user.set_anotherUserMailInput(username);
        user.select_selectAnotherUserMailBtn();
        user.select_datePickerDate();
        user.select_areaPickerArea();
        user.select_emptyDesk();
        user.finish_deskBooking();

    }
}
