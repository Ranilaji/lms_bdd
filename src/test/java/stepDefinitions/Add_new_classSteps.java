package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.ClassDetailPop_upPage;
import pageObjects.ClassPage;
import utils.ExcelReader;

public class Add_new_classSteps {
	
	public static WebDriver driver;	
	ClassPage classpage=new ClassPage();
	ClassDetailPop_upPage classpopUp=new ClassDetailPop_upPage();
	
	@Given("Admin is in  class detail popup window")
	public void admin_is_in_class_detail_popup_window() {
		
	}
	
	@When("Admin enters all mandatory field values with valid data from excel {string} and {int} and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_all_mandatory_field_values_with_valid_data_from_excel_and_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData(".\\testData\\Add_class.xlsx", sheetName);		
			
		String Batch_id=testData.get(rowNumber).get("Batch_id");
		String no_of_classes=testData.get(rowNumber).get("no_of_classes");
		String class_date=testData.get(rowNumber).get("class_date");
				
		String staff_id=testData.get(rowNumber).get("staff_id");
		classpopUp.EnterBatchId(Batch_id);
		classpopUp.EnterNoOfClasses(no_of_classes);
		classpopUp.EnterClassDate(class_date);
		classpopUp.EnterStaffId(staff_id);
		
	}
	@Then("Admin should see new class details is added in the data table")
	public void admin_should_see_new_class_details_is_added_in_the_data_table() {
		
	}
	}