package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import utils.ConfigReader;

public class ResetPassword {

	public static WebDriver driver = DriverFactory.getdriver();
	String resetURL = ConfigReader.getResetUrl();


	@FindBy(id = "loginButton")
	WebElement Loginbtn;

	@FindBy(linkText = "Reset Password")
	WebElement Resetbtn;

	@FindBy(id = "Error Message")
	WebElement errormessage;

	public ResetPassword() {

		PageFactory.initElements(driver, this);
	}

	public void clickLoginButton() {

		Loginbtn.click();
	}
	
	public void loadresetpage() {

		driver.get(resetURL);

	}

	public void clickResetPasswordLink() {

		Resetbtn.click();
	}

	public String getErrorMessage() {
		WebElement errorMessageElement = driver.findElement(By.id("errorMessage"));
		return errorMessageElement.getText();
	}

	public void enterNewPassword(String newPassword) {
		WebElement newPasswordField = driver.findElement(By.id("newPassword"));
		newPasswordField.sendKeys(newPassword);
	}

	public void enterConfirmPassword(String confirmPassword) {
		WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void clickSubmitButton(String newPassword) {
		WebElement newPasswordField = driver.findElement(By.id("newPassword"));
		newPasswordField.sendKeys(newPassword);
	}
}
