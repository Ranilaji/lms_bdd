package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import utils.ConfigReader;

public class DashboardPage {
	public DashboardPage()
	
		{
			PageFactory.initElements(driver, this);
		}
	
	public static WebDriver driver=DriverFactory.getdriver();
	String URL=ConfigReader.dashboardPageURL();
	
	public void dashboardURL()
	{
		driver.get(URL);
	}
	
	
	@FindBy(linkText="class_link")WebElement class_link;
	
	String exp_title="Home Login";
	
	public boolean verifyTitleDashboardPage()
	{
		boolean result=false;
		if(driver.getTitle().equalsIgnoreCase(exp_title))
		{
			result=true;
		}
		return result;
	}
	
	public void clickClassLink()
	{
		class_link.click();
	}
	
	public long captureResponseTime()
	{
		long startTime = System.currentTimeMillis();
		class_link.click();
		long endTime = System.currentTimeMillis();
		 long responseTime = endTime - startTime;
		 return responseTime;
	}
	
}
