package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomeSteps {

	WebDriver driver;
	HomePage home = new HomePage();

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		home.loadhomepage();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url(String homeurl) {

	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {

		String expectedTitle = "HomePage";
		String actualTitle = home.getPageTitle();
		assertEquals(actualTitle, expectedTitle, "admin is on home page");

	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url(String homeurl) {
		boolean exp_Url = home.verifyInvalidURL(homeurl);
		assertTrue(exp_Url, "Invalid LMS ");
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error() {
		String errorHeadingText = home.getErrorHeadingText();
		assertTrue(errorHeadingText.contains("404"), "Error-Page not found");
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer code) throws IOException, InterruptedException {
		int respCode = home.findBrokenLinks(code);
		assertTrue(respCode >= 400, "Link broken with response code" + respCode);

	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() throws InterruptedException {
		home.clk_Login();
	}

}
