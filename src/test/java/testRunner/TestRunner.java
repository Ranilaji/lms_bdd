package testRunner;

//import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/features",
				  glue = {"stepDefinitions", "hooks"},
				  monochrome = true,				  
				  plugin= {"pretty",
						  "html:target/cucumber.html",
						  //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						  },
				  //tags= ("@test"),
				  dryRun = false
				)
public class TestRunner extends AbstractTestNGCucumberTests {

	
}