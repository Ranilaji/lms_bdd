package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.ClassPage;


public class Class_PaginationSteps {
	
	
	public static WebDriver driver;	
	ClassPage classpage=new ClassPage();
	

	@Then("Right arrow should be enabled in page one  when entries are more than five available")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_five_available() {
		Assert.assertTrue(classpage.verify_right_arrow_enable(), "Error-right arrow is not enabled");
		
	}
	
	@Then("Left arrow should be disabled in page one  when entries are more than five available")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_five_available() {
		Assert.assertTrue(classpage.verify_left_arrow_disable(), "Error-left arrow is enabled");
	}	
	
	@Then("Right arrow should be enabled in page two when entries are more than ten available")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_ten_available() {
		Assert.assertTrue(classpage.verify_right_arrow_enable_OnPge2(), "Error-right arrow is not enabled");
		
	}
	
	@Then("Left arrow should be enabled in page two")
	public void left_arrow_should_be_enabled_in_page_two() {
		Assert.assertTrue(classpage.verify_left_arrow_enable_OnPage2(), "Error-left arrow is disabled");
	}
	
	@Then("Data table should display  page one  when entries available")
	public void data_table_should_display_page_one_when_entries_available() {
		Assert.assertTrue(classpage.verify_right_arrow_disable_OnPge2(), "Error-right arrow is enabled when entries are less than 10");
	}
	
	@Then("pagination controls should be enabled when entries are more than five in data table")
	public void pagination_controls_should_be_enabled_when_entries_are_more_than_five_in_data_table() {
		Assert.assertTrue(classpage.verify_pagination_controls_enabled(),"ERROR-pagination controls are disabled for more than 5 entries");
	}
	
	@Then("pagination controls should be disabled when entries are less than five in data table")
	public void pagination_controls_should_be_disabled_when_entries_are_less_than_five_in_data_table() {
		Assert.assertFalse(classpage.verify_pagination_controls_disabled(),"Error-pagination controls are enabled for less than 5 entries");
		
	}
	
	
}