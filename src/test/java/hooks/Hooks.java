package hooks;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.ConfigReader;

public class Hooks {
	
	private static WebDriver driver;
	private static DriverFactory driverfactory;
	static Scenario scenario;

	@BeforeAll
	public static void before() throws Throwable {
		//Get browser Type from config file
		System.out.println("Loading Config file");
		ConfigReader.loadConfig();
		String browser = ConfigReader.getBrowserType();
		
		//Initialize driver from driver factory
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeDrivers(browser);
		
		System.out.println("Initializing driver for : " +browser);
		
	}
	
	@Before
	public static void setup() {
		
		DriverFactory.getdriver();
		
	}
		@Before
		public void scenario(Scenario scenario) {
			System.out.println("===============================================================================================");
			System.out.println(scenario.getSourceTagNames() +" : "+scenario.getName());
			System.out.println("-----------------------------------------------------------------------------------------------");
			
		}
		@AfterStep
		public void afterstep(Scenario scenario) {
			if (scenario.isFailed()) {
				System.out.println("Steps Failed , Taking Screenshot");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "My screenshot");
				Allure.addAttachment("Myscreenshot",
						new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			
			}
		}
		
		@AfterAll
		public static void after() {
			System.out.println("Closing Driver");
			driverfactory.closeallDriver();
		}
	
	}