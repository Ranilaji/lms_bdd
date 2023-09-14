package stepDefinitions;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AssignmentPage;
import utils.ConfigReader;
import utils.ExcelReader;
//import utils.Loggerload;

public class AddNewAssignment_SD {
	
	AssignmentPage ap = new AssignmentPage();
	String Excelpath = ConfigReader.getExcelFilePath();
	ExcelReader excelreader = new ExcelReader();
	String programName, batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4, assignmentfile5;	
	String assignmentDuedate, errorMsg;

	@Given("Admin is in  assignment details popup window")
	public void admin_is_in_assignment_details_popup_window() {
		ap.clkANewAssignmentBtn();
	}

	@When("Admin enters all mandatory field values with valid data from {string} and {int} and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_valid_data_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
		
	}
	
	@Then("Admin should see new assignment details is added in the data table")
	public void admin_should_see_new_assignment_details_is_added_in_the_data_table() {
		
		//how to check if the assignment is added		
	}

	@When("Admin enters all mandatory field values with invalid data from {string} and {int} and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Error message should appear in alert")
	public void error_message_should_appear_in_alert() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin enters values in all fields with valid data from {string} and {int} and clicks save button")
	public void admin_enters_values_in_all_fields_with_valid_data_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile2 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile3 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile4 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile5 = usertestdata.get(rownumber).get("Assignment File 5");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@When("Admin enters with invalid data in optional fields from {string} and {int} and clicks save button")
	public void admin_enters_with_invalid_data_in_optional_fields_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@When("Admin enters  data missing value in program name from {string} and {int} and clicks save button")
	public void admin_enters_data_missing_value_in_program_name_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Program Name is missing")
	public void program_name_is_missing() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin enters data missing value in Batch number from {string} and {int} and clicks save button")
	public void admin_enters_data_missing_value_in_batch_number_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Batch number is missing")
	public void batch_number_is_missing() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin enters data missing value in Assignment name from {string} and {int} and clicks save button")
	public void admin_enters_data_missing_value_in_assignment_name_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Assignment name is missing")
	public void assignment_name_is_missing() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin enters data missing value in Assignment due date from {string} and {int} and clicks save button")
	public void admin_enters_data_missing_value_in_assignment_due_date_from_and_and_clicks_save_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Assignment due date is missing")
	public void assignment_due_date_is_missing() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin enters data missing value in grade by from {string} and {int} and clicks save button")
	public void admin_enters_data_missing_value_in_grade_by_from_and_and_clicks_save_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Grade by is missing")
	public void grade_by_is_missing() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin enters passed date in the due date field from {string} and {int} and clicks save button")
	public void admin_enters_passed_date_in_the_due_date_field_from_and_and_clicks_save_button(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		errorMsg = usertestdata.get(rownumber).get("Error Message");
		ap.clkSaveBtn(programName,batchNumber, assignmentName, assignmentDesc, gradeBy, assignmentDuedate, assignmentfile1, assignmentfile2, assignmentfile3, assignmentfile4,assignmentfile5 );
	}

	@Then("Assignment cannot be created for the passed date")
	public void assignment_cannot_be_created_for_the_passed_date() {
		String errMsg = ap.verifyErrMsg();
		Assert.assertEquals(errMsg, errorMsg);
	}

	@When("Admin clicks date from date picker")
	public void admin_clicks_date_from_date_picker() {
		ap.clkAssignDatePicker();
	}

	@Then("selected date should be their in class date text box")
	public void selected_date_should_be_their_in_class_date_text_box() {
		ap.getassignDuedateTextboxValue();
	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format")
	public void selected_date_should_be_in_mm_dd_yyyy_format() throws InterruptedException {
		ap.getApplicationUrl();
		Thread.sleep(2000);
		ap.validateDateFormat();
	}

	@When("Admin clicks right arrow in the date picker near month")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month() {

	}

	@Then("Next month calender should visible")
	public void next_month_calender_should_visible() {

	}

	@When("Admin clicks left arrow in the date picker near month")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month() {

	}

	@Then("previous month calender should visible")
	public void previous_month_calender_should_visible() {

	}

	@When("Admin clicks date picker button")
	public void admin_clicks_date_picker_button() {

	}

	@Then("Admin should see current date is highled in the date picker")
	public void admin_should_see_current_date_is_highled_in_the_date_picker() {

	}

	@When("Admin clicks date picker button and selects future date")
	public void admin_clicks_date_picker_button_and_selects_future_date() {

	}

	@Then("Admin should see selected date is highled in the date picker")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker() {

	}

	@When("Admin clicks Cancel button without entering values in the fields")
	public void admin_clicks_cancel_button_without_entering_values_in_the_fields() {
		ap.clkCancelBtn();
	}

	@Then("Admin should land on manage assignment page")
	public void admin_should_land_on_manage_assignment_page() {
		ap.chkManageAssignPageTitle();
	}

	@When("Admin clicks Cancel button entering values in the fields from {string} and {int}")
	public void admin_clicks_cancel_button_entering_values_in_the_fields_from_and(String sheetname, Integer rownumber) 
			throws InvalidFormatException, IOException {
		List<Map<String, String>> usertestdata = excelreader.getData(Excelpath, sheetname);
		programName = usertestdata.get(rownumber).get("Program Name");
		batchNumber = usertestdata.get(rownumber).get("Batch Number");
		assignmentName = usertestdata.get(rownumber).get("Assignment Name");
		assignmentDesc = usertestdata.get(rownumber).get("Assignment Description");
		gradeBy = usertestdata.get(rownumber).get("Grade By");
		assignmentDuedate = usertestdata.get(rownumber).get("Assignment Due Date");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 1");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 2");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 3");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 4");
		assignmentfile1 = usertestdata.get(rownumber).get("Assignment File 5");
		ap.clkCancelBtn();
	}

	@Then("Admin should land on manage assignment Page and validate new assignment is not created in the data table")
	public void admin_should_land_on_manage_assignment_page_and_validate_new_assignment_is_not_created_in_the_data_table() {
		//how to validate new record is not created
	}	
}