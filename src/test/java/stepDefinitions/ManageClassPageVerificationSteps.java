package stepDefinitions;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utils.ConfigReader;

public class ManageClassPageVerificationSteps {
	
	public static WebDriver driver;	
	LoginPage loginpage=new LoginPage();
	DashboardPage dashpage=new DashboardPage();
	ClassPage classpage=new ClassPage();
	
@Given("admin is on Login page after clicking on Login button on home page")
public void admin_is_on_login_page_after_clicking_on_login_button_on_home_page() {
		loginpage.applicationUrl();
		loginpage.clickLoginButton();
	}

	@When("admin enters valid login and password")
	public void admin_enters_valid_login_and_password() {
		loginpage.EnterUserAndPassword();
		
	}
	
	@When("clicks on login button")
	public void clicks_on_login_button() {
		loginpage.clickOnLogin();
	}

	@Then("admin navigated to dashboard page")
	public void admin_navigated_to_dashboard_page() {
	
		boolean exp_title=dashpage.verifyTitleDashboardPage();
		Assert.assertTrue(exp_title,"Error-actual title is not mathcing with expected title");
		
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	   dashpage.dashboardURL();
	}

	@When("Admin clicks Class button on the navigation bar")
	public void admin_clicks_class_button_on_the_navigation_bar() {
	    dashpage.clickClassLink();
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String classurl) {
		
		Assert.assertTrue(classpage.validateClassURL(classurl),"ERROR-actual url is different than Expected url");
	
	}
	
	@Then("Get the response time for navigation from dashboard page to manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {
		long reponseTime=dashpage.captureResponseTime();
		System.out.println("response time is:"+reponseTime);
	}
	
	@Then("Admin should see header with Manage Class")
	public void admin_should_see_header_with_manage_class() {
		
		boolean result=classpage.verify_Manage_class_header();
		Assert.assertTrue(result,"ERROR-Manage Class header is not displayed");
		
	}
	
	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
		boolean result=classpage.navBar_fields_spelling_Check();
		Assert.assertTrue(result,"Error- incorrect spelling found");
		
	}
	
	@Then("Admin should see disabled delete icon below the Manage Class")
	public void admin_should_see_disabled_delete_icon_below_the_manage_class() {
		Assert.assertFalse(classpage.verify_Delete_button(), "Error-delete button is enabled");
	}
	
	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {
	   
		Assert.assertTrue(classpage.verify_search_bar(),"ERROR-search bar not displayed");
	}

	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {
		Assert.assertTrue(classpage.verify_add_new_button(),"ERROR-Add new button is not displayed");;
	}
	
	@Then("Admin should see data table on the Manage Class Page With following column headers check box batch id classno class date class topic staff id description comments notes recording EditDelete")
	public void admin_should_see_data_table_on_the_manage_class_page_with_following_column_headers_check_box_batch_id_classno_class_date_class_topic_staff_id_description_comments_notes_recording_edit_delete() {
		Assert.assertTrue(classpage.verify_table_column_headers(),"ERROR-heading not displayed");
		
	}
	
	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		
		Assert.assertTrue(classpage.verify_Edit_Icon_visible(),"ERROR-Edit Icon not displayed");
		
	}
	
	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		Assert.assertFalse(classpage.verify_Edit_Icon_visible(),"ERROR-Edit Icon is displayed");
	}
	
	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		Assert.assertTrue(classpage.verify_Delete_icon_displayed(),"ERROR-delete icon not displayed");
	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		Assert.assertFalse(classpage.verify_Delete_icon_displayed(),"ERROR-delete icon is displayed");
	}
	
	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		
		Assert.assertTrue(classpage.verify_PresenceOfsortArrows_Except_EditDelete(),"sort arrow present at EditDelete icon");
		
	}
	
	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		Assert.assertTrue(classpage.Verify_presence_Of_checkbox(),"checkbox not displayed");
	}
	
	@Then("Admin should see text showing entries")
	public void admin_should_see_text_showing_entries() {
		classpage.validate_number_entries();
		
	}
	
	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		Assert.assertTrue(classpage.verify_pagination_controls(),"pagination controls not displayed");
	}

	@Then("Admin should see the text with total number classes in the data tabl")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_tabl() {
		
		classpage.validate_footer_text();
	}
	
	@Given("Admin is on Manage Class Page")
	public void admin_is_on_manage_class_page() {
	   classpage.manageClassURL();
	}

	@When("Admin enters {string} into search box")
	public void admin_enters_into_search_box(String batch_id) {
		classpage.Enter_value_to_search_bar(batch_id);
	}

	@Then("Displays entries for valid values only")
	public void displays_entries_for_valid_values_only() {
			if(classpage.validate_search_box_function())
			{
				Assert.assertTrue(true,"ERROR- Invalid data entered");
			}
			else
			{
				Assert.assertTrue(false,"ERROR- Showing Entries for invalid data");
			}
	   
	}

	@When("Admin enters {string} into the search box")
	public void admin_enters_into_the_search_box(String class_no) {
		classpage.Enter_value_to_search_bar(class_no);
		}
	
	@Then("entries are displayed for valid values only")
	public void entries_are_displayed_for_valid_values_only() {
	   
		if(classpage.validate_search_box_function())
		{
			Assert.assertTrue(true,"ERROR- Invalid data entered");
		}
		else
		{
			Assert.assertTrue(false,"ERROR- Showing Entries for invalid data");
		}
	}

	@When("Admin enters {string} in the search box")
	public void admin_enters_in_the_search_box(String class_topic) {
		classpage.Enter_value_to_search_bar(class_topic);
		
	}

	@Then("Displayed entries are for valid values only")
	public void displayed_entries_are_for_valid_values_only() {
	   
		if(classpage.validate_search_box_function())
		{
			Assert.assertTrue(true,"ERROR- Invalid data entered");
		}
		else
		{
			Assert.assertTrue(false,"ERROR- Showing Entries for invalid data");
		}
	}

	@When("Admin enters both valid and invalid {string} into search box")
	public void admin_enters_both_valid_and_invalid_into_search_box(String staff_id) {
	 
		classpage.Enter_value_to_search_bar(staff_id);
	}

	@Then("it Displays entries for valid values only")
	public void it_displays_entries_for_valid_values_only() {
		
		if(classpage.validate_search_box_function())
		{
			Assert.assertTrue(true,"ERROR- Invalid data entered");
		}
		else
		{
			Assert.assertTrue(false,"ERROR- Showing Entries for invalid data");
		}
	}

	@When("Admin enters valid and invalid {string} into search box")
	public void admin_enters_valid_and_invalid_into_search_box(String class_date) {
		
		classpage.Enter_value_to_search_bar(class_date);
	   
	}

	@Then("Displayed entries  for valid dates only")
	public void displayed_entries_for_valid_dates_only() {
		if(classpage.validate_search_box_function())
		{
			Assert.assertTrue(true,"ERROR- Invalid data entered");
		}
		else
		{
			Assert.assertTrue(false,"ERROR- Showing Entries for invalid data");
		}
	    
	}



	}