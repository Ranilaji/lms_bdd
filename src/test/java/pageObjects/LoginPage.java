package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import utils.ConfigReader;

public class LoginPage {
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
		
		public static WebDriver driver=DriverFactory.getdriver();
		String URL=ConfigReader.getApplicationUrl();
		String user=ConfigReader.adminUsername();
		String pass=ConfigReader.adminPassword();
		
		public void applicationUrl() {

			driver.get(URL);

		}
	
		@FindBy(id="login_button")WebElement login_button;
		@FindBy(id="user")WebElement username;
		@FindBy(id="password")WebElement password;
		@FindBy(id="login")WebElement click_login;
	
		
		public void clickLoginButton()
		{
			login_button.click();
		}
		
		public void EnterUserAndPassword()
		{
			username.sendKeys(user);
			password.sendKeys(pass);
		}
		
		public void clickOnLogin()
		{
			click_login.click();
		}
	}
