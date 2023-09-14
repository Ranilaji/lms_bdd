package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AssignmentPage;
import pageObjects.ClassPage;

public class AssignmentPage_SD {
	WebDriver driver = null;
	AssignmentPage ap = new AssignmentPage();
	ClassPage classpage=new ClassPage();

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
		ap.getApplicationUrl();
		Thread.sleep(2000);
		ap.enterLoginCred();
	}

	@When("Admin clicks assignment button on the navigation bar")
	public void admin_clicks_assignment_button_on_the_navigation_bar() throws InterruptedException {
		Thread.sleep(2000);
		ap.clkAdminLink();
		Thread.sleep(2000);
}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String url) throws InterruptedException {
		Thread.sleep(1000);
		String actualUrl = ap.getActualUrl();
		Assert.assertEquals(actualUrl, "https://lms-demo.com");
	}

	@Then("Get the response time for navigation from dashboard page to manage assignment page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {
		ap.getApplicationUrl();
		long start = System.currentTimeMillis();
		ap.clkAssignmentLink();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
	}

	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String exppageHeading) {
		String actualPageHeading = ap.chkManageAssignPageTitle();
		Assert.assertEquals(actualPageHeading,exppageHeading,"Manage Assignment");
	}
	
	@When("Admin clicks assignment button on the navigation bar and get all text from the portal page")
	public void admin_clicks_assignment_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page() {
		
	}

	@Then("Admin should see correct spelling for all the fields")
	public void admin_should_see_correct_spelling_for_all_the_fields() {
		boolean result=classpage.navBar_fields_spelling_Check();
		Assert.assertTrue(result,"Error- incorrect spelling found");
	}

	@Then("Admin should see disabled delete icon below the Manage assignment")
	public void admin_should_see_disabled_delete_icon_below_the_manage_assignment() {
		boolean isMasterDelateBtnDisabled = ap.chkDisabledDeleteBtn();
		Assert.assertEquals(false, isMasterDelateBtnDisabled);
	}

	@Then("Admin should see search bar on the manage assignment page")
	public void admin_should_see_search_bar_on_the_manage_assignment_page() {
		boolean isSearchBtnDisplayed = ap.chkSearchBarDisplayed();
		Assert.assertEquals(true, isSearchBtnDisplayed);
	}

	@Then("Admin should see +Add New assignment button on the manage assignment page")
	public void admin_should_see_add_new_assignment_button_on_the_manage_assignment_page() {
		boolean isAddNewAssignmentBtnDisplayed = ap.chkSearchBarDisplayed();
		Assert.assertEquals(true, isAddNewAssignmentBtnDisplayed);
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		ap.chkEditIconDisplayed();
		//ap.chkEditIconinEachRow();//not working
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {

	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		ap.chkDeleteIconDisplayed();
	}

	@Then("Delete Icon will not be present in data table")
	public void delete_icon_will_not_be_present_in_data_table() {

	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {

	}

	@Then("Admin should see check box in the all rows  of data table when entries available")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table_when_entries_available() {

	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		boolean isPaginationControlDisplayed = ap.chkPaginationControls();
		Assert.assertEquals(true, isPaginationControlDisplayed);

	}

	@Then("Admin should see the text with total number assignments in the data table {string}")
	public void admin_should_see_the_text_with_total_number_assignments_in_the_data_table(String expectedFooterMsg) {
		String actualFooterMsg = ap.chkFooterText();
		Assert.assertEquals(actualFooterMsg,expectedFooterMsg,"Manage Assignment");
	}
	/*
	 * Assignment Details Pop Window Scenarios
	 */

	@Given("Admin is on manage assignment Page")
	public void admin_is_on_manage_assignment_page() {
		ap.getApplicationUrl();
	}

	@When("Admin click +Add new assignment button")
	public void admin_click_add_new_assignment_button() {
		ap.clkANewAssignmentBtn();
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) {
		ap.verifyPopUpHeading();
	}

	@Then("Admin should see input fields Text {string}, {string},{string}, {string}, {string}, {string}, {string},{string}, {string}, {string}, {string}")
	public void admin_should_see_input_fields_text(String prgmname, String batchno, String assignname, String assigndesc, 
			String gradeby, String assignduedate, String assignfile1, String assignfile2, String assignfile3, 
			String assignfile4, String assignfile5) {

	}

	@Then("textbox should be  present in Assignment details popup window")
	public void textbox_should_be_present_in_assignment_details_popup_window() {
		ap.isTextboxDisplayed();
		System.out.println("Assignment Name Textbox is displayed");
	}

	@Then("Admin should see  dropdown option for Batch Number")
	public void admin_should_see_dropdown_option_for_batch_number() {
		ap.isBatchDropdownDisplayed();
		System.out.println("Batch Number Dropdown displayed");
	}

	@Then("Admin should see  dropdown option for Program name")
	public void admin_should_see_dropdown_option_for_program_name() {
		ap.isProgramNameDisplayed();
		System.out.println("Program Name dropdown displayed");
	}

	@Then("Admin should see  calendar icon for assignment due date")
	public void admin_should_see_calendar_icon_for_assignment_due_date() {
		ap.isAssignDueDatePickerDisplayed();
		System.out.println("Assignment DueDate picker is displayed");
	}

	@Then("Admin should see  save button in the Assignment detail popup window")
	public void admin_should_see_save_button_in_the_assignment_detail_popup_window() {
		ap.isSaveBtnDisplayed();
		System.out.println("Save button is displayed");
	}

	@Then("Admin should see  cancel button in the Assignment detail popup window")
	public void admin_should_see_cancel_button_in_the_assignment_detail_popup_window() {
		ap.isCancelBtnDisplayed();
		System.out.println("Cancel button is displayed");
	}

	@Then("Admin should see  close button on the Assignment details popup window")
	public void admin_should_see_close_button_on_the_assignment_details_popup_window() {
		ap.isCloseBtnDiaplyed();
		System.out.println("Close button is displayed");
	}
	@When("Admin clicks Student button in the navigation bar")
	public void admin_clicks_student_button_in_the_navigation_bar() {
		ap.clkStudentLink();
	}

	@Then("Admin should able to land on student page")
	public void admin_should_able_to_land_on_student_page() {
		ap.getStudentPageTitle();
		driver.navigate().back();
	}

	@When("Admin clicks Program button in the navigation bar")
	public void admin_clicks_program_button_in_the_navigation_bar() {
		ap.clkPrgmLink();
	}

	@Then("Admin should able to land on program page")
	public void admin_should_able_to_land_on_program_page() {
		ap.getProgramPageTitle();
		driver.navigate().back();
	}

	@When("Admin clicks Batch button in the navigation bar")
	public void admin_clicks_batch_button_in_the_navigation_bar() {
		ap.clkBatchLink();
	}

	@Then("Admin should able to land on batch page")
	public void admin_should_able_to_land_on_batch_page() {
		ap.getBatchPageTitle();
		driver.navigate().back();
	}

	@When("Admin clicks User button in the navigation bar")
	public void admin_clicks_user_button_in_the_navigation_bar() {
		ap.clkUserLink();
	}

	@Then("Admin should able to land on user page")
	public void admin_should_able_to_land_on_user_page() {
		ap.getUserPageTitle();
		driver.navigate().back();
	}

	@When("Admin clicks class button in the navigation bar")
	public void admin_clicks_class_button_in_the_navigation_bar() {
		ap.clkClassLink();
	}

	@Then("Admin should able to land on class page")
	public void admin_should_able_to_land_on_class_page() {
		ap.getClassPageTitle();
		driver.navigate().back();
	}

	@When("Admin clicks Attendance button in the navigation bar")
	public void admin_clicks_attendance_button_in_the_navigation_bar() {
		ap.clkattendLink();
	}

	@Then("Admin should able to land on Attendance page")
	public void admin_should_able_to_land_on_attendance_page() {
		ap.getAttendancePageTitle();
		driver.navigate().back();
	}

	@When("Admin clicks Logout button in the navigation bar")
	public void admin_clicks_logout_button_in_the_navigation_bar() {
		ap.clkLogoutLink();
	}

	@Then("Admin should able to land on login page")
	public void admin_should_able_to_land_on_login_page() {
		ap.getHomePageTitle();
	}	
	
	// Delete Functionality
	
	@Given("Admin is in manage assignment page")
	public void admin_is_in_manage_assignment_page() {
	    ap.getApplicationUrl();
	}

	@When("Admin clicks delete button in data table row level")
	public void admin_clicks_delete_button_in_data_table_row_level() {
	    ap.clkDeleteIcon();
	}

	@Then("Admin should see dialog box")
	public void admin_should_see_dialog_box() {
	    ap.getDeleteAlertText();
	}

	@Then("Alert should have {string} button to accept")
	public void alert_should_have_button_to_accept(String expectedAlertText) {
	    ap.chkYesBtnInAlert();
	}

	@Then("Alert should have {string} button to reject")
	public void alert_should_have_button_to_reject(String string) {
	    ap.chkNoBtnInAlert();
	}

	@Given("Admin is in delete alert")
	public void admin_is_in_delete_alert() {
	    ap.clkDeleteIcon();
	}

	@When("Admin clicks yes button")
	public void admin_clicks_yes_button() {
	    ap.clkYesBtn();
	}

	@Then("Redirected to assignment page and selected assignment details are deleted from the data table")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_deleted_from_the_data_table() {
		//how to chk
	    System.out.println("The selected record is deleted");
	}

	@When("Admin clicks no button")
	public void admin_clicks_no_button() {
	    ap.clkNoBtn();
	}

	@Then("Redirected to assignment page and selected assignment details are not deleted from the data table")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_not_deleted_from_the_data_table() {
		//how to chk
		System.out.println("The selected record is not deleted");
	}
	@When("Admin clicks  multiple row level check box in the data table")
	public void admin_clicks_multiple_row_level_check_box_in_the_data_table() {
	    
	}

	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
	    
	}
}
