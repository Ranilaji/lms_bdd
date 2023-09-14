package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.DriverFactory;

public class ElementsUtils {
	
	WebDriver driver = DriverFactory.getdriver();
	
	public void waitForElement(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
	}

	public void enterText(String Text, WebElement element) {

		new Actions(driver).sendKeys(element, Text).perform();
	}
	
	//Finding number of Rows
	
	

	

	//Finding number of Columns

	/*List<WebElement> columnsNumber = driver.findElements(By.xpath(""));
	int columnCount = columnsNumber.size();
	System.out.println("No of columns in this table : " + columnCount);

	//Finding cell value at 4th row and 3rd column

	WebElement cellAddress = Rowtable.findElement(By.xpath(“//*[@id="content-8b4988b9-2ec9-4e77-9b4d-9c2994bd9e8a"]/div/div/table[1]/tbody/tr[4]/td[3]”));
	String value = cellAddress.getText();
	System.out.println(“The Cell Value is : “ +value);*/
}
