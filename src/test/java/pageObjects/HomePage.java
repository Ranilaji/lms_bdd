package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import utils.ConfigReader;

public class HomePage {

	public static WebDriver driver = DriverFactory.getdriver();
	String URL = ConfigReader.getApplicationUrl();

	@FindBy(xpath = "//h1[contains(text(),'404')]")
	WebElement errorHeading;

	@FindBy(xpath = ".//input[@value='Login']")
	WebElement Loginbtn;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void loadhomepage() {

		driver.get(URL);

	}

	public String getPageTitle() {

		String title = driver.getTitle();
		return title;

	}

	public boolean verifyInvalidURL(String url) {
		boolean result = false;
		if (driver.getCurrentUrl().endsWith("portal.com")) {
			return true;
		}
		return result;

	}

	public String getErrorHeadingText() {
		return errorHeading.getText();
	}

	public int findBrokenLinks(int responsecode) throws IOException, InterruptedException {
		List<WebElement> links = driver.findElements(By.linkText("a"));

		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");

			URL link = new URL(url);

			// create a connection using url object link
			HttpURLConnection http = (HttpURLConnection) link.openConnection();
			// wait time 2 seconds
			Thread.sleep(1000);
			// establish connection
			http.connect();
			int resCode = http.getResponseCode();
			if (resCode >= 400) {
				System.out.println(url + "-" + "is broken link");
			} else {
				System.out.println(url + "-" + "is valid broken link");
			}

		}
		return responsecode;

	}

	public void clk_Login() throws InterruptedException {
		Loginbtn.click();
		Thread.sleep(2000);
	}

}