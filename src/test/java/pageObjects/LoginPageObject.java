package pageObjects;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import io.cucumber.datatable.DataTable;

public class LoginPageObject {
public static WebDriver driver = DriverFactory.getdriver();

	@FindBy(xpath = ".//input[@value='Login']")
	WebElement Loginbtn;

	@FindBy(id = "userName")
	WebElement successfulmessage;

	@FindBy(id = "userName")
	WebElement userspellcheck;

	@FindBy(id = "password")
	WebElement passwordspellcheck;

	@FindBy(id = "username")
	WebElement txtuser;

	@FindBy(id = "password")
	WebElement txtpassword;

	@FindBy(id = "verifypasswordasterik")
	WebElement verifypasswordfield;

	@FindBy(id = "verifyuserasterik")
	WebElement verifyuserfield;

	@FindBy(id = "verifyalignmentuser")
	WebElement verifyalignmentuserfield;

	@FindBy(xpath = "//*[@id='validusername']")
	WebElement validuser;
	@FindBy(xpath = "//*[@id='validpassword']")
	WebElement validpassword;

	@FindBy(id = "username")
	WebElement Loginid;

	@FindBy(id = "password")
	WebElement Loginpwd;

	@FindBy(className = "submit")
	WebElement SubmitBtt;

	public String username;

	public String password;

	public LoginPageObject() {

		PageFactory.initElements(driver, this);
	}

	public String getLoginTitle() {

		String title = driver.getTitle();
		return title;

	}

	public void clk_Login() throws InterruptedException {
		Loginbtn.click();
		Thread.sleep(2000);
	}

	public void printMessage() {
		String text = successfulmessage.getText();
	}

	public boolean isUserPresent() {
		try {
			driver.findElement(By.id("user"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isPasswordPresent() {
		try {
			driver.findElement(By.id("password"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isUserSpellingCorrect(String username) {
		userspellcheck.sendKeys(username);
		String actualUserSpelling = userspellcheck.getAttribute("value");
		return actualUserSpelling.equals(username);
	}

	public boolean isPasswordSpellingCorrect(String password) {
		passwordspellcheck.sendKeys(password);
		String actualPasswordSpelling = passwordspellcheck.getAttribute("value");
		return actualPasswordSpelling.equals(password);
	}

	public String verifyUserText(String user) {
		return txtuser.getText();
	}

	public String verifyPasswordText(String password) {
		return txtpassword.getText();
	}

	public String enterPassword(String password) {
		verifypasswordfield.clear();
		verifypasswordfield.sendKeys(password);
		return password;
	}

	public String enterUser(String user) {
		verifyuserfield.clear();
		verifyuserfield.sendKeys(password);
		return user;
	}

	public void entervalidUsername(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String userName = form.get("username");
			validuser.sendKeys(userName);
		}
	}

	public void entervalidPassword(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String passwd = form.get("password");

			validpassword.sendKeys(passwd);

		}

	}

	/*public void SubmitBtt() {
		SubmitBtt.click();
	}

	public Boolean verifySubmitEnabled() {
		return SubmitBtt.isEnabled();

	}

	public void enterusername(String SS) {
		Loginid.sendKeys(SS);
	}

	public void enterpassword(String pSS) {
		Loginpwd.sendKeys(pSS);
	}

	public void login() {
		enterusername("admin");
		enterpassword("admin");

		if (verifySubmitEnabled()) {
			SubmitBtt();
		}

	}*/

}

