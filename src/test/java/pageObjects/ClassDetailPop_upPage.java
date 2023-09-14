package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import utils.ConfigReader;

public class ClassDetailPop_upPage {

	public ClassDetailPop_upPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	public static WebDriver driver=DriverFactory.getdriver();
	String URL=ConfigReader.manageClassURL();
	
	public void manageClassURL() {

	driver.get(URL);

	}
	@FindBy(xpath="")WebElement pop_up_heading;
	@FindBy(xpath="")WebElement batch_id;
	@FindBy(xpath="")WebElement no_of_classes;
	@FindBy(xpath="")WebElement class_date;
	@FindBy(xpath="")WebElement class_topic;
	@FindBy(xpath="")WebElement staff_id;
	@FindBy(xpath="")WebElement class_desc;
	@FindBy(xpath="")WebElement comments;
	@FindBy(xpath="")WebElement notes;
	@FindBy(xpath="")WebElement recordings;
	@FindBy(xpath="")List<WebElement> pop_up_fields;
	@FindBy(xpath="")WebElement batch_drop_dn;
	@FindBy(xpath="")WebElement staffIDdrpdn;
	@FindBy(xpath="")WebElement classDateIcon;
	@FindBy(xpath="")WebElement savebtn;
	@FindBy(xpath="")WebElement cancelbtn;
	@FindBy(xpath="")WebElement closebtn;
	
	
public void EnterBatchId(String batchid)
{
	batch_id.sendKeys(batchid);
}

public void EnterNoOfClasses(String classes)
{
	no_of_classes.sendKeys(classes);
}

public void EnterClassDate(String date)
{
	class_date.sendKeys(date);
}

public void EnterStaffId(String staffid)
{
	staff_id.sendKeys(staffid);
}

public void EnterclassTopic(String topic)
{
	class_topic.sendKeys(topic);
}

public void EnterclassDescription(String desc)
{
	class_desc.sendKeys(desc);
}

public void EnterclassComments(String comm)
{
	comments.sendKeys(comm);
}

public void EnterclassNotes(String note)
{
	notes.sendKeys(note);
}

public void Enterclassrecordings(String record)
{
	recordings.sendKeys(record);
}

	public boolean verify_all_PopUpfields()
	{
		boolean result=false;
		for(WebElement field:pop_up_fields)
		{
			if(field.isDisplayed())
			{
				return true;
			}
		}
		return result;
	}
	public boolean verify_batch_drop_dn()
	{
		return batch_drop_dn.isDisplayed();
	}
	public boolean verify_staffIDdrpdn()
	{
		return staffIDdrpdn.isDisplayed();
	}
	public boolean verify_classDateIcon()
	{
		return classDateIcon.isDisplayed();
	}
	public boolean verify_savebtn()
	{
		return savebtn.isDisplayed();
	}
	public boolean verify_cancelbtn()
	{
		return cancelbtn.isDisplayed();
	}
	public boolean verify_closebtn()
	{
		return closebtn.isDisplayed();
	}
	
	public boolean verify_class_details_heading()
	{
		return pop_up_heading.isDisplayed();
	}
}
