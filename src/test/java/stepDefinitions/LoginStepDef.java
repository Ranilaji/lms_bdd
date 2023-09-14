package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPageObject;


public class LoginStepDef {

	WebDriver driver;
	HomePage home = new HomePage();
	LoginPageObject login = new LoginPageObject();
	String username;
	String password;

	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
		String expectedTitle = "HomePage";
		String actualTitle = home.getPageTitle();
		assertEquals(actualTitle, expectedTitle, "admin is on home page");
	}

	@When("Admin clicks Login button should see {string} message")
	public void admin_clicks_login_button_should_see_message(String message) throws InterruptedException {
		login.clk_Login();
		Assert.assertEquals(message, "login button", "Login successfull");
	}

	@Then("Admin should see {string} in the header")
	public void admin_should_see_in_the_header(String headertext) {
		login.printMessage();
		Assert.assertEquals(headertext, "login page", "Please login to LMS application in the header");

	}

	@Then("Admin should see two text field {string} and {int}")
	public void admin_should_see_two_text_field_and() {
		boolean isUserNamePresent = login.isUserPresent();
		boolean isPasswordPresent = login.isPasswordPresent();

		if (!isUserNamePresent || !isPasswordPresent) {
			throw new AssertionError("Not all text fields are present");
		}
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		String expectedUsernameSpelling = "admin"; // Replace with the expected spelling
		String expectedPasswordSpelling = "password";
		Assert.assertTrue(login.isUserSpellingCorrect(login.username));
		Assert.assertTrue(login.isPasswordSpellingCorrect(login.password));

	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String user) {
		String ActualText = "user";
		String ExpectedText = login.verifyUserText(user);
		Assert.assertEquals(ActualText, ExpectedText);
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String password) {
		String ActualText = "password";
		String ExpectedText = login.verifyUserText(password);
		Assert.assertEquals(ActualText, ExpectedText);
	}

	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		String passwordText = login.enterPassword(password);
		Assert.assertTrue("Asterisk (*) not found next to password text", passwordText.contains("*"));
	}

	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		String userText = login.enterUser(password);
		Assert.assertTrue("Asterisk (*) not found next to user text", userText.contains("*"));
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		String expectedTitle = "LoginPage";
		String actualTitle = login.getLoginTitle();
		assertEquals(actualTitle, expectedTitle, "admin is on login page");
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button(io.cucumber.datatable.DataTable dataTable) {
		login.entervalidUsername(dataTable);
		login.entervalidPassword(dataTable);
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		String Title = home.getPageTitle();
		assertEquals(Title, "Homepage", "Title do not match");
	}
	
	
}
