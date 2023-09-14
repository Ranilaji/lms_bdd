package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.AssignmentPage;
import pageObjects.ClassDetailPop_upPage;
import pageObjects.ClassPage;

public class ClassDetailPopUpWindow {
	
	public static WebDriver driver;	
	ClassPage classpage=new ClassPage();
	ClassDetailPop_upPage cdpage=new ClassDetailPop_upPage();
	AssignmentPage ap = new AssignmentPage();
	
	
	@Given("Admin is on manage class page")
	public void admin_is_on_manage_class_page() {
	   classpage.manageClassURL();
	}

	@When("Admin click +Add New Class button")
	public void admin_click_add_new_class_button() {
	   classpage.click_Add_New_button();
	}

	@Then("Admin should see a popup  with  heading class details")
	public void admin_should_see_a_popup_with_heading_class_details() {
	
	   Assert.assertTrue(cdpage.verify_class_details_heading(),"ERROR-Class Details heading is not dispalyed");
	}
	
	@Then("Admin should see input fields Text Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings")
	public void admin_should_see_input_fields_text_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings() {
		Assert.assertTrue(cdpage.verify_all_PopUpfields(),"fields are not displayed on pop up window");
	}
	
	@Then("Admin should see  dropdown option for Batch ID")
	public void admin_should_see_dropdown_option_for_batch_id() {
		Assert.assertTrue(cdpage.verify_batch_drop_dn(),"Dropdown for batch id is not dispalyed");
	   
	}

	@Then("Admin should see  dropdown option for Staff Id")
	public void admin_should_see_dropdown_option_for_staff_id() {
		Assert.assertTrue(cdpage.verify_staffIDdrpdn(),"Drop-Down for staff id is not presnt");
	   
	}

	@Then("Admin should see  calendar icon for class date")
	public void admin_should_see_calendar_icon_for_class_date() {
		Assert.assertTrue(cdpage.verify_classDateIcon(),"calender icon is not present");
	   
	}

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
		Assert.assertTrue(cdpage.verify_savebtn(),"Save button not displayed");
	   
	}

	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
	    
		Assert.assertTrue(cdpage.verify_cancelbtn(),"Cancel button not present");
	}

	@Then("Admin should see  close button on the class details popup window")
	public void admin_should_see_close_button_on_the_class_details_popup_window() {
		Assert.assertTrue(cdpage.verify_closebtn(),"Close button not present");		
	   
	}



}
