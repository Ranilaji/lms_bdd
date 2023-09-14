package pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hooks.DriverFactory;
import io.cucumber.datatable.DataTable;
import utils.ConfigReader;

public class AssignmentPage {
	public static WebDriver driver= DriverFactory.getdriver();
	String url = ConfigReader.getApplicationUrl();

	public AssignmentPage() {

		PageFactory.initElements(driver, this);		
	}

	@FindBy(xpath ="//a[@href=\"a-new-assignment\"]")WebElement headerAssignmentLink;
	@FindBy(xpath ="//a[@href=\"upload-assignment\"]")WebElement uploadAssignmentBtn;
	@FindBy(xpath = "//a[@href=\"search-assignment\"]")WebElement searchTextbox;
	@FindBy(xpath = "//button[@id=\"master-delete-button\"]")WebElement masterDeleteBtn;
	@FindBy(xpath = "//input[@name=\"search-textbox\"]")WebElement searchTxtbox;
	@FindBy(xpath="fields_on_nav_bar")List<WebElement> navBar;

	@FindBy(xpath = "//button[@class=\"pagination-page-item--page-selected\"]")WebElement selectedPageNumber;
	@FindBy(xpath = "//button[@class=\"pagination-page-item--page\"]")WebElement pageNumber;
	@FindBy(xpath = "//button[@class=\"class=\"pagination-page-item--previous-next\"]")WebElement singleLeftArrowLink;
	@FindBy(xpath = "//div/nav/ul[@class=\"oxd-pagination__ul\"]")WebElement paginationControls;

	@FindBy(xpath = "//div/nav/ul[@class=\"oxd-footer_text\"]")WebElement footerText;
	@FindBy(xpath = "//div[@class=\"oxd-table-body\"]")WebElement dynamicWebtableBody;

	@FindBy(xpath = "//a[@href=\"student\"]")WebElement studentLink;
	@FindBy(xpath = "//a[@href=\"program\"]")WebElement programLink;
	@FindBy(xpath = "//a[@href=\"batch\"]")WebElement batchLink;
	@FindBy(xpath = "//a[@href=\"class\"]")WebElement classLink;
	@FindBy(xpath = "//a[@href=\"user\"]")WebElement userLink;
	@FindBy(xpath = "//a[@href=\"assignment\"]")WebElement assignmentLink;
	@FindBy(xpath = "//a[@href=\"attendance\"]")WebElement attendanceLink;	
	@FindBy(xpath = "//a[@href=\"logout\"]")WebElement logoutLink;
	
	@FindBy(xpath = "//div/span/h6[@class=\"manage-assignment-heading\"]")WebElement headingManageAssignment;
	@FindBy(xpath = "//button/i[@class=\"edit-icon bi-pencil-fill\"]")WebElement editIconLink;
	@FindBy(xpath = "//button/i[@class=\"delete-icon\"]")WebElement deleteIconLink;
	@FindBy(xpath = "//div[@class=\"oxd-table-header\"]")WebElement headerInfo;

	// Assignment Details

	@FindBy(xpath ="//a[@href=\"a-new-assignment\"]") WebElement aNewAssignmentBtn;
	
	@FindBy(xpath ="//input[@class=\"assignmentName-textbox\"]") WebElement assignmentNameTxtbox;
	@FindBy(xpath ="//input[@class=\"assignmentDesc-textbox\"]") WebElement assignmentDescTxtbox;
	@FindBy(xpath ="//input[@class=\"gradeBy-textbox\"]") WebElement gradeByTxtbox;
	@FindBy(xpath ="//select[@id=\"batchNumber-dropdowm-menu\"]") WebElement batchnoDropdown;
	@FindBy(xpath ="//select[id=\"programName-dropdown-menu\"]") WebElement programNameDropdown;
	@FindBy(xpath ="//i[@class=\"glyphicon glyphicon-calendar\"]") WebElement assignDueDatePicker;
	@FindBy(xpath ="//input[@class=\"assignment-duedate\"]") WebElement assignDueDateTextbox;
	@FindBy(xpath ="//*[@class='react-datepicker__week']//*[text()='12']")WebElement selectDate;
	@FindBy(xpath ="//input[@class=\"assignment-file1-textbox\"]") WebElement assignmentFile1Txtbox;
	@FindBy(xpath ="//input[@class=\"assignment-file2-textbox\"]") WebElement assignmentFile2Txtbox;
	@FindBy(xpath ="//input[@class=\"assignment-file3-textbox\"]") WebElement assignmentFile3Txtbox;
	@FindBy(xpath ="//input[@class=\"assignment-file4-textbox\"]") WebElement assignmentFile4Txtbox;
	@FindBy(xpath ="//input[@class=\"assignment-file5-textbox\"]") WebElement assignmentFile5Txtbox;
		
	@FindBy(xpath ="//i[@class=\"glyphicon glyphicon-calendar\"]") WebElement saveBtn;
	@FindBy(xpath ="//i[@class=\"glyphicon glyphicon-calendar\"]") WebElement cancelBtn;
	@FindBy(xpath ="//i[@class=\"glyphicon glyphicon-calendar\"]") WebElement closeBtn;

	@FindBy(xpath ="//label[@id=\"userName-label\"]") WebElement programNameLabel;
	@FindBy(xpath ="//label[@id=\"batchNumber-label\"]") WebElement batchNumberLabel;
	@FindBy(xpath ="//label[@id=\"assignmentName-label\"]") WebElement assignmentNameLabel;
	@FindBy(xpath ="//label[@id=\"assignmentDescription-label\"]") WebElement assignmentDescLabel;
	@FindBy(xpath ="//label[@id=\"grade-by-label\"]") WebElement gradeByLabel;
	@FindBy(xpath ="//label[@id=\"assignmentDueDate-label\"]") WebElement assignmentDueDateLabel;
	@FindBy(xpath ="//label[@id=\"assignmentFile1-label\"]") WebElement assignmentFile1Label;
	@FindBy(xpath ="//label[@id=\"assignmentFile2-label\"]") WebElement assignmentFile2Label;
	@FindBy(xpath ="//label[@id=\"assignmentFile3-label\"]") WebElement assignmentFile3Label;
	@FindBy(xpath ="//label[@id=\"assignmentFile4-label\"]") WebElement assignmentFile4Label;
	@FindBy(xpath ="//label[@id=\"assignmentFile5-label\"]") WebElement assignmentFile5Label;
	
	@FindBy(xpath = "//button[@class=\"yes-button-in-alert\"]")WebElement yesBtnInDeleteAlert;
	@FindBy(xpath = "//button[@class=\"yes-button-in-alert\"]")WebElement noBtnInDeleteAlert;
	
	//OrangeHRm homepage
	@FindBy(xpath = "//input[@name=\"username\"]")WebElement usernameOHRM;
	@FindBy(xpath = "//input[@name=\"password\"]")WebElement pwdOHRM;
	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")WebElement loginBtn;
	@FindBy(xpath = "//div/ul/li/a[@href=\"/web/index.php/admin/viewAdminModule\"]")WebElement adminLink;

	public String getAddAssignmentTitle() {
		String addAssignmentPageTitle = driver.getTitle();
		return addAssignmentPageTitle;
	}
	public void clk_uploadAssignmentBtn() {
		uploadAssignmentBtn.click();
		//Loggerload.info("User is in Upload Assignment pop up window");
	}
	public String getUploadAssignemntTitle() {
		String UploadAssignemntTitle = driver.getTitle();
		return UploadAssignemntTitle;
	}
	public void getApplicationUrl() {
		driver.get(url);		
	}

	//OrangeHRM
	public void enterLoginCred() {
		usernameOHRM.sendKeys("Admin");
		pwdOHRM.sendKeys("admin123");
		loginBtn.click();

	}
	public void clkAdminLink() {
		adminLink.click();
	}

	public void clkAssignmentLink() {
		headerAssignmentLink.click();
	}

	public boolean chkEditIconDisplayed() {
		return(editIconLink.isDisplayed());
	}
	public boolean chkDeleteIconDisplayed() {
		return(deleteIconLink.isDisplayed());
	}

	public boolean chkDisabledDeleteBtn() {
		return(masterDeleteBtn.isEnabled());
	}

public boolean chkSearchBarDisplayed() {
		return(searchTextbox.isDisplayed());
	}

	public boolean chkAddNewAssignmentBtnDisplayed() {
		return(aNewAssignmentBtn.isDisplayed());
	}

	public String getRegisterPageTitle() {
		String registerPageTitle = driver.getTitle();
		return registerPageTitle;
	}

	public String getActualUrl() {
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		return actualUrl;
	}

	public void totalNoOfRowsinManageAssignment() {

	}
	public void totalNoOfRows(WebElement element) {
		List<WebElement> rowsNumber = (List<WebElement>) dynamicWebtableBody;
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
	}

	public void chkEditIconinEachRow() {
		List<WebElement> totalRows = driver.findElements(By.className("oxd-table"));
		int rowcount = totalRows.size();
		System.out.println("No of rows in this table : " + rowcount);
		if (rowcount > 0) {
			for (int i =0; i < rowcount; i++) {
				editIconLink.isDisplayed();
			}
			System.out.println("There is no records in table");		
		}

	}

	public boolean chkPaginationControls() {
		return(paginationControls.isDisplayed());
	}

	public String chkManageAssignPageTitle() {
		String pageHeading = headingManageAssignment.getText();
		return pageHeading;
	}

	public String chkFooterText() {
		int totalRows =  driver.findElements(By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\"]")).size();
		String footerMsg = footerText.getText();
		return footerMsg;
	}

	public void enterSigninCredentials(DataTable credentialTable ) {

		for(Map<String,String>usercredential : credentialTable.asMaps(String.class,String.class)) {

			/*UsernameTxtbox.sendKeys(usercredential.get("username"));
			PasswordTxtbox.sendKeys(usercredential.get("password"));	*/		

		}
	}

	public void chkColumnHeaders()
	{
		int rows =  driver.findElements(By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\"]")).size();
		//int rows =  driver.findElements(By.xpath("//div[@class=\"oxd-table\"]")).size();
		System.out.println(rows);
		//int cols = driver.findElements(By.xpath("//div[@class=\"oxd-table-header-sort\"]")).size();
		//System.out.println(cols);

		List<String> headerNames = new ArrayList();
		//headerInfo.getText();
		headerNames.add(headerInfo.getText());
		System.out.println(headerNames);

	}

	//Search box functionality

	public String searchbyAssignmentName() {
		searchTextbox.clear();
		searchTextbox.sendKeys("Assignment_Name");
		searchTextbox.sendKeys(Keys.ENTER);
		String result = dynamicWebtableBody.getText();
		return result;

	}
	/*
	 * Assignment Details Pop up Window
	 */	

	public void clkANewAssignmentBtn() {
		aNewAssignmentBtn.click();
		//Loggerload.info("User is in Assignment Details pop up window");
	}

	public void verifyPopUpHeading() {
		String parentWindowHandle = driver.getWindowHandle(); // get the current window handle
		aNewAssignmentBtn.click();
		for (String winHandle : driver.getWindowHandles()) {

		         if(!winHandle.equals(parentWindowHandle))
		         {
		            driver.switchTo().window(winHandle);
		            System.out.println("Title of the new window: " +
		            driver.getTitle());
		            System.out.println("Closing the new window...");
		            driver.close();
		         }
		   }   
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Parent window URL: " + driver.getCurrentUrl());
	}
	
	

	public List<String> chkInputFieldsText() {
		
		List<String> inputField = new ArrayList();
		
		String prgNameText = programNameLabel.getText();
		inputField.add(prgNameText);		
		String batchNoText = batchNumberLabel.getText();
		inputField.add(batchNoText);
		String assignNameText = assignmentNameLabel.getText();
		inputField.add(assignNameText);
		String assignDesText = assignmentDescLabel.getText();
		inputField.add(assignDesText);
		String gradeByText = gradeByLabel.getText();
		inputField.add(gradeByText);
		String assignDDText = assignmentDueDateLabel.getText();
		inputField.add(assignDDText);
		String assignFile1Text = assignmentFile1Label.getText();
		inputField.add(assignFile1Text);
		String assignFile2Text = assignmentFile2Label.getText();
		inputField.add(assignFile2Text);
		String assignFile3Text = assignmentFile3Label.getText();
		inputField.add(assignFile3Text);
		String assignFile4Text = assignmentFile4Label.getText();
		inputField.add(assignFile4Text);
		String assignFile5Text = assignmentFile5Label.getText();
		inputField.add(assignFile5Text);
		return inputField;	
		
		}
	
	public void isTextboxDisplayed() {
		assignmentNameTxtbox.isDisplayed();
	}
	public void isBatchDropdownDisplayed() {
		batchnoDropdown.isDisplayed();
	}
	public void isProgramNameDisplayed() {
		programNameDropdown.isDisplayed();
	}
	public void isAssignDueDatePickerDisplayed() {
		assignDueDatePicker.isDisplayed();
	}
	public void isSaveBtnDisplayed() {
		saveBtn.isDisplayed();
	}
	public void isCancelBtnDisplayed() {
		cancelBtn.isDisplayed();
	}
	public void isCloseBtnDiaplyed() {
		closeBtn.isDisplayed();
	}
	public void clkCancelBtn() {
		cancelBtn.isDisplayed();
	}
	public void clkCloseBtn() {
		closeBtn.click();
	}
	public String verifyErrMsg() {		
		String errMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errMsg;		
	}
	public void clkAssignDatePicker() {
		assignDueDatePicker.click();
	}
	public String getassignDuedateTextboxValue() {
		String assignduedate = assignDueDateTextbox.getText();
		return assignduedate;
	}	
	public void validateDateFormat() {
		assignDueDatePicker.click();
		selectDate.click();
		String dateToValidate = assignDueDateTextbox.getText();
		System.out.println("Date to validate:" +dateToValidate);
	    SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
	    //To make strict date format validation
	    formatter.setLenient(false);
	    Date parsedDate = null;
	    try {
	        parsedDate = formatter.parse(dateToValidate);
	        System.out.println("++validated DATE TIME ++"+formatter.format(parsedDate));

	    } catch (ParseException e) {
	    	e.printStackTrace();
	    }
	    System.out.println("parsedDate" +parsedDate);
	}
	
	public void clkSaveBtn(String programname, String batchnumber, String assignmentname, String assignmentdesc, String gradeby, String assignmentduedate, 
			String assignfile1, String assignfile2, String assignfile3, String assignfile4, String assignfile5) {
		programNameDropdown.clear();
		programNameDropdown.sendKeys(programname);
		batchnoDropdown.clear();
		batchnoDropdown.sendKeys(batchnumber);
		assignmentNameTxtbox.clear();
		assignmentNameTxtbox.sendKeys(assignmentname);
		gradeByTxtbox.clear();
		gradeByTxtbox.sendKeys(gradeby);
		assignDueDateTextbox.clear();
		assignDueDateTextbox.sendKeys(assignmentduedate);
		assignmentFile1Txtbox.clear();
		assignmentFile1Txtbox.sendKeys(assignfile1);
		assignmentFile2Txtbox.clear();
		assignmentFile2Txtbox.sendKeys(assignfile2);
		assignmentFile3Txtbox.clear();
		assignmentFile3Txtbox.sendKeys(assignfile3);
		assignmentFile4Txtbox.clear();
		assignmentFile4Txtbox.sendKeys(assignfile4);
		assignmentFile5Txtbox.clear();
		assignmentFile5Txtbox.sendKeys(assignfile5);	
		saveBtn.click();
	}
	public boolean navBar_fields_spelling_Check()
	{
		boolean result=false;
		for(WebElement fields:navBar)
		{
			String fieldText=fields.getText();
			
			if(fieldText.contains("Desktops")||fieldText.contains("Laptops&Notebooks")
					||fieldText.contains("Components")||fieldText.contains("Tablets")
					||fieldText.contains("Software")||fieldText.contains("Phones & PDAs")
					||fieldText.contains("Cameras")||fieldText.contains("MP3 Player"))
			{
				result=true;
			}
			
		}
		return result;
	}
	//Edit Assignment
	public void clkEditIconLink() {
		assignDueDatePicker.click();
	}
	
	//Navigation function
	public void clkStudentLink() {
		studentLink.click();
	}
	public void clkPrgmLink() {
		programLink.click();
	}
	public void clkBatchLink() {
		batchLink.click();
	}
	public void clkClassLink() {
		classLink.click();
	}
	public void clkUserLink() {
		userLink.click();
	}
	public void clkAssignLink() {
		assignmentLink.click();
	}
	public void clkattendLink() {
		attendanceLink.click();
	}
	public void clkLogoutLink() {
		logoutLink.click();
	}
	public String getStudentPageTitle() {
		String studentPageTitle = driver.getTitle();
		return studentPageTitle;
	}
	public String getProgramPageTitle() {
		String programPageTitle = driver.getTitle();
		return programPageTitle;
	}
	public String getBatchPageTitle() {
		String batchPageTitle = driver.getTitle();
		return batchPageTitle;
	}
	public String getClassPageTitle() {
		String classPageTitle = driver.getTitle();
		return classPageTitle;
	}
	public String getUserPageTitle() {
		String userPageTitle = driver.getTitle();
		return userPageTitle;
	}
	public String getAssignmentPageTitle() {
		String assignmentPageTitle = driver.getTitle();
		return assignmentPageTitle;
	}
	public String getAttendancePageTitle() {
		String attendancePageTitle = driver.getTitle();
		return attendancePageTitle;
	}
	public String getHomePageTitle() {
		String lmsHomePageTitle = driver.getTitle();
		return lmsHomePageTitle;
	}
	
	//Delete Assignment
	public void clkDeleteIcon() {
		deleteIconLink.click();
	}
	public String getDeleteAlertText() {
		String deleteMsg = driver.switchTo().alert().getText();
		return deleteMsg;
		//Dialog dialog = new Dialog(context);		
	}
	public void chkYesBtnInAlert() {
		yesBtnInDeleteAlert.isDisplayed();
	}
	public void chkNoBtnInAlert() {
		noBtnInDeleteAlert.isDisplayed();
	}
	public void clkYesBtn() {
		yesBtnInDeleteAlert.click();
	}
	public void clkNoBtn() {
		noBtnInDeleteAlert.click();
	}
	public void acceptDeleteAlert() {
		driver.switchTo().alert().accept();
	}
	
	//Search Functionality
	public void sendSearchTxt(String searchtext) {
		searchTxtbox.sendKeys(searchtext);
		searchTxtbox.sendKeys(Keys.RETURN);
	}
	

}
