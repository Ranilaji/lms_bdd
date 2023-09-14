package pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.reactivex.rxjava3.functions.Action;

public class StudentPage {

	WebDriver driver = new ChromeDriver();

	// after login

	public void clickStudent() {

		WebElement student = driver.findElement(By.className(""));
		System.out.println("click on student");
		student.click();

	}

	// 1.validate the title of page

	public void verifyTitle() {
		String Studentpagetitle = driver.getTitle();
		System.out.println("Title of the page is " + Studentpagetitle);

		String expextedTitle = "Student Details Page";
		Assert.assertEquals(Studentpagetitle, expextedTitle);
	}

	// 2.validate response time
	public void responseTime() {

		long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		System.out.println("Total Page Load Time: " + totalTime + " milliseconds");

	}

	// 4.validate LMStitle
	public void lmsTitle() {

		WebElement Student = driver.findElement(By.id("01"));
		Student.click();
		String LmsTitle = driver.getTitle();
		System.out.println("Title of the page is " + LmsTitle);

		String expextedTitle = "LMS -Learning management system";
		Assert.assertEquals(LmsTitle, expextedTitle);
	}

	// 5.validate drodown

	public void StudentdropDown() {

		String arr[] = { "Select", "Sname1", "Sname2", "Sname3" };
		WebElement dropDownS = driver.findElement(By.id("02"));
		Select s = new Select(dropDownS);
		List<WebElement> options = s.getOptions();
		boolean match = false;
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText() + " == " + arr[i]);
			if (options.get(i).getText().equals(arr[i])) {

				match = true;
			}

			Assert.assertTrue(match);
		}
	}
	// 6.Validate search bar in select student name drop down

	public void studentSearchbox() {

		WebElement searchBox_student = driver.findElement(By.className("class"));

		if (searchBox_student.isDisplayed()) {
			System.out.println("Search Box is visible " + searchBox_student.isDisplayed());
		} else {
			System.out.println("Search Box is not visible" + searchBox_student.isDisplayed());
		}

		// Verify that the “Search” Box is enabled
		if (searchBox_student.isEnabled()) {
			System.out.println("Search Box is enabled " + searchBox_student.isEnabled());
			searchBox_student.sendKeys("Selenium");
		} else {
			System.out.println("Search Box is not enabled " + searchBox_student.isEnabled());
		}

		System.out.println("Successful Execution of Test.");

	}

	// 7.Validate search bar in select batch id drop down
	public void batchidSearchbox() {

		WebElement searchBox_batchid = driver.findElement(By.id("03"));

		if (searchBox_batchid.isDisplayed()) {
			System.out.println("Search Box is visible " + searchBox_batchid.isDisplayed());
		} else {
			System.out.println("Search Box is not visible" + searchBox_batchid.isDisplayed());
		}

		// Verify that the “Search” Box is enabled
		if (searchBox_batchid.isEnabled()) {
			System.out.println("Search Box is enabled " + searchBox_batchid.isEnabled());
			searchBox_batchid.sendKeys("Selenium");
		} else {
			System.out.println("Search Box is not enabled " + searchBox_batchid.isEnabled());
		}

		System.out.println("Successful Execution of Test.");

	}

	// 11.Validate only numbers inside select batch id
	public void BatchiddropDownNo() {

		String arr[] = { "Select", "01", "02", "03" };
		WebElement dropDownBid = driver.findElement(By.id("02"));
		Select s = new Select(dropDownBid);
		List<WebElement> options = s.getOptions();
		boolean match = false;
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText() + " == " + arr[i]);
			if (options.get(i).getText().equals(arr[i])) {

				match = true;
			}

			Assert.assertTrue(match);
		}
	}
	// TS 9,10 spell check
	// TS-12 and 13 Validate gray color in student name drop down

	public void verifyColor() {

		WebElement StudentnameColor = driver.findElement(By.id("04"));

		String colorCode = StudentnameColor.getCssValue("color");

		System.out.println("Color code is" + colorCode);

		String expectedColorCode = "gray";
		// Asserting actual and expected color codes
		Assert.assertEquals(colorCode, expectedColorCode);

	}

	// Ts-14--Validate first drop down label is select student name
	public void studentDropDownLabel() {

		WebElement StudentDDLabel = driver.findElement(By.name("name"));
		System.out.println("Name of the Email Textbox is:- " + StudentDDLabel.getAttribute("Select Student Name"));
	}

	// Ts-15--Validate second drop down label is select student name
	public void batchidDropDownLabel() {

		WebElement batchidlabel = driver.findElement(By.name("name"));
		System.out.println("Name of the Email Textbox is:- " + batchidlabel.getAttribute("Select Batch Id"));
	}

	// --TS-16 Validate scroll down inside student name dropdown

	public void scrollDownStudent() {

		WebElement targetElement = driver.findElement(By.id(""));

		Actions actions = new Actions(driver);
		actions.scrollToElement(targetElement).perform();
	}

	// --TS-17 Validate scroll down inside batch id dropdown
	public void scrollDownbatchId() {

		WebElement targetElementbatch = driver.findElement(By.id(""));

		Actions actions = new Actions(driver);
		actions.scrollToElement(targetElementbatch).perform();
	}
	// navigation bar
	// TS-25 to TS31Program link on navigation bar

	public void navigationProgram() {

		WebElement program = driver.findElement(By.className("class1"));
		System.out.println("click on program");
		program.click();

	}

	public void navigationBatch() {

		driver.navigate().back();

		WebElement batch = driver.findElement(By.className("class2"));
		System.out.println("click on batch");
		batch.click();
	}

	public void navigationClass() {
		driver.navigate().back();

		WebElement classb = driver.findElement(By.className("class3"));
		System.out.println("click on classb");
		classb.click();
	}

	public void navigationUser() {
		driver.navigate().back();

		WebElement user = driver.findElement(By.id("05"));
		System.out.println("click on user");
		user.click();

	}

	public void navigationAssignment() {

		driver.navigate().back();

		WebElement assignment = driver.findElement(By.xpath(""));
		System.out.println("click on assignment");
		assignment.click();
		System.out.println("assignment page");
	}

	public void navigationAttendance() {
		driver.navigate().back();

		WebElement attandance = driver.findElement(By.className(""));
		System.out.println("click on attendance");
		attandance.click();
		driver.navigate().back();
	}

	public void navigationLogout() {

		WebElement logout = driver.findElement(By.className(""));
		System.out.println("click on logout");
		logout.click();

		// driver.navigate().back();
	}

}

