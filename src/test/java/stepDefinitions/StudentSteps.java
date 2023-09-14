package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.commons.math3.geometry.Space;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pageObjects.BatchPage;
//import pageObjects.LoginPage;
import pageObjects.StudentPage;

public class StudentSteps {

	//LoginPage LP = new LoginPage();
	StudentPage SP = new StudentPage();
	

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {

		SP.clickStudent();

	}

	@Then("Admin should see the Student details Page Title")
	public void admin_should_see_the_student_details_page_title() {

		SP.verifyTitle();
		System.out.println(" Admin is on Student details page");

	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {

		SP.responseTime();

	}

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {

		SP.lmsTitle();
		System.out.println(" LMS-Learning Managment system");
	}

	@Then("Admin should see search box inside the drop down")
	public void admin_should_see_search_box_inside_the_drop_down() {

	}

	@Then("Admin should see only numbers inside batch id drop down")
	public void admin_should_see_only_numbers_inside_batch_id_drop_down() {

		SP.BatchiddropDownNo();

	}

	@Then("Admin should see select student name in gray color")
	public void admin_should_see_select_student_name_in_gray_color() {

		SP.verifyColor();

	}

	@Then("Admin should see select student name in first")
	public void admin_should_see_select_student_name_in_first() {

		SP.studentDropDownLabel();

	}

	@Then("Admin should see select batch id in second")
	public void admin_should_see_select_batch_id_in_second() {

		SP.batchidDropDownLabel();

	}

	@Then("Admin should able to scroll down to select the name")
	public void admin_should_able_to_scroll_down_to_select_the_name() {

		SP.scrollDownStudent();

	}

	@Then("Admin should able to scroll down to select the batch id")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id() {

	SP.scrollDownbatchId();

	}

	
	@When("Admin selects  student name and batch id")
	public void admin_selects_student_name_and_batch_id() {

	}

	@Then("Particular student informations should be display")
	public void particular_student_informations_should_be_display() {

	}

}
