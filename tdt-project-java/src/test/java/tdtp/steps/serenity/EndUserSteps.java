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

    @Step
    public void select_addNewBookingBtn() {
        manageBookingsPage.select_addNewBookingBtn();
    }

    @Step
    public void select_datePickerDate() {
        manageBookingsPage.select_datePickerDate();
    }

    @Step
    public void select_areaPickerArea() {
        manageBookingsPage.select_areaPickerArea();
    }

    @Step
    public void select_emptyDesk() {
        manageBookingsPage.select_emptyDesk();
    }

    @Step
    public void finish_deskBooking() {
        manageBookingsPage.finish_deskBooking();
    }

    @Step
    public void delete_firstElementOfUpcomingBookings() {
        manageBookingsPage.delete_firstElementOfUpcomingBookings();
    }

    @Step
    public void select_bookForAnotherUserBtn() {
        manageBookingsPage.select_bookForAnotherUserBtn();
    }

    @Step
    public void set_anotherUserMailInput(String mail) {
        manageBookingsPage.set_anotherUserMailInput(mail);
    }

    @Step
    public void select_selectAnotherUserMailBtn() {
        manageBookingsPage.select_selectAnotherUserMailBtn();
    }

    @Step
    public void goToBuildingsPage() {
        buildingsPage.goToBuildingsPage();
    }

    @Step
    public void set_buildingName(String name) {
        buildingsPage.set_buildingName(name);
    }

    @Step
    public void set_safeDistance(String dist) {
        buildingsPage.set_safeDistance(dist);
    }

    @Step
    public void createNewBuilding() {
        buildingsPage.createNewBuilding();
    }

    @Step
    public void set_addNewBuildingBtn() {
        buildingsPage.set_addNewBuildingBtn();
    }

    @Step
    public void select_buildingActionsIndex7() {
        buildingsPage.select_buildingActionsIndex7();
    }

    @Step
    public void select_deleteBuilding() {
        buildingsPage.select_deleteBuilding();
    }

    @Step
    public void select_editBuilding() {
        buildingsPage.select_editBuilding();
    }

    @Step
    public void set_editBuildingsName() {
        buildingsPage.set_editBuildingsName();
    }

    @Step
    public void set_editBuildingsSafeDistance() {
        buildingsPage.set_editBuildingsSafeDistance();
    }

    @Step
    public void select_saveEditedBuilding() {
        buildingsPage.select_saveEditedBuilding();
    }

    @Step
    public void select_deskCanvas() {
        desksPage.select_deskCanvas();
    }

    @Step
    public void set_newDeskPupUpLabelInput(String label) {
        desksPage.set_newDeskPupUpLabelInput(label);
    }

    @Step
    public void select_saveNewDeskBtn() {
        desksPage.select_saveNewDeskBtn();
    }

    @Step
    public void set_newEquipmentNameInput(String name) {
        desksPage.set_newEquipmentNameInput(name);
    }

    @Step
    public void select_newEquipmentCreateBtn() {
        desksPage.select_newEquipmentCreateBtn();
    }

    @Step
    public void set_editEquipmentNameInput(String newName) {
        desksPage.set_editEquipmentNameInput(newName);
    }

    @Step
    public void select_editEquipmentHiddenBtn() {
        desksPage.select_editEquipmentHiddenBtn();
    }

    @Step
    public void select_saveEditedEquipmentName() {
        desksPage.select_saveEditedEquipmentName();
    }

    @Step
    public void select_deleteEquipmentBtn() {
        desksPage.select_saveEditedEquipmentName();
    }

    @Step
    public void select_addNewDeskBtn() {
        desksPage.select_addNewDeskBtn();
    }

    @Step
    public void set_newDeskPopUpAssignToInput(String assign) {
        desksPage.set_newDeskPopUpAssignToInput(assign);
    }

    @Step
    public void select_manageEquipmentListBtn() {
        desksPage.select_manageEquipmentListBtn();
    }

}
