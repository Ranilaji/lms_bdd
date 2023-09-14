package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import utils.ConfigReader;

public class ClassPage {
	
		public ClassPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	public static WebDriver driver=DriverFactory.getdriver();
	String URL=ConfigReader.manageClassURL();
	
	public void manageClassURL() {

		driver.get(URL);

	}
	

		
		
	@FindBy(xpath="manage_class_header")WebElement header;
	@FindBy(xpath="fields_on_nav_bar")List<WebElement> navBar;
	@FindBy(id="delete_button")WebElement delete_btn;
	@FindBy(xpath="web_table_headings")List<WebElement> tableHeadings;
	@FindBy(xpath="web_table_entries")List<WebElement> entries;
	@FindBy(xpath="edit_icons")List<WebElement> editIcon;
	@FindBy(xpath="delete_icons")List<WebElement> deleteIcon;
	@FindBy(xpath="sort_arrows")List<WebElement> sortArrows;
	@FindBy(xpath="checkbox")List<WebElement> checkboxes;
	@FindBy(xpath="active_page")WebElement active_page;
	@FindBy(xpath="pagination controls")List<WebElement> pagi_controls;
	@FindBy(xpath="footer_text")WebElement footer_text;
	@FindBy(xpath="search_bar")WebElement search_bar;
	@FindBy(xpath="")WebElement search_btn;
	@FindBy(xpath="add_new_button")WebElement add_btn;
	@FindBy(xpath="")WebElement pagi_text;
	@FindBy(xpath="")WebElement page1;
	
	
	public boolean verify_pagination_controls_disabled()
	{
		boolean result=false;
		String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
		int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
		for(WebElement control:pagi_controls)
		{
			if(total_entries<5)
			{
			if(control.isDisplayed())
			{
				result=true;
			}
			else{
				result=false;
				}
			}
		}
			return result;
	}
	
	public boolean verify_pagination_controls_enabled()
	{
		boolean result=false;
		String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
		int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
		for(WebElement control:pagi_controls)
		{
			if(total_entries>5)
			{
			if(control.isDisplayed())
			{
				result=true;
			}
			else{
				result=false;
				}
			}
		}
			return result;
	}
		
		
	public boolean verify_right_arrow_enable()
	{
		boolean result=false;
		String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
		int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
		if(total_entries>5)
		{
			WebElement right_arrow= driver.findElement(By.xpath(""));
			if(right_arrow.isEnabled())
			{
				result=true;
			}
		}
		return result;
	}
	
	public boolean verify_right_arrow_enable_OnPge2()
	{
		boolean result=false;
		String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
		int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
		if(total_entries>10)
		{
			WebElement right_arrow= driver.findElement(By.xpath(""));
			if(right_arrow.isEnabled())
			{
				result=true;
			}
		}
		return result;
	}
	
	public boolean verify_right_arrow_disable_OnPge2()
	{
		boolean result=true;
		String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
		int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
		if(total_entries<10)
		{
			WebElement right_arrow= driver.findElement(By.xpath(""));
			if(right_arrow.isEnabled())
			{
				result=false;
			}
		}
		return result;
	}
	
	public boolean verify_left_arrow_disable()
	{
		boolean result=true;
		String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
		int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
		if(total_entries>5)
		{
			WebElement left_arrow= driver.findElement(By.xpath(""));
			if(left_arrow.isEnabled())
			{
				result=false;
			}
		}
		return result;
	}
	


public boolean verify_left_arrow_enable_OnPage2()
{
	boolean result=false;
	String text=pagi_text.getText();	//Showing 1 to 2 of 2 entries
	int total_entries=Integer.parseInt(text.substring(text.indexOf("f")+2,text.indexOf("e")-1));
	if(total_entries>10)
	{
		WebElement left_arrow= driver.findElement(By.xpath(""));
		if(left_arrow.isEnabled())
		{
			result=true;
		}
	}
	return result;
}


	
	public void click_Add_New_button()
	{
		add_btn.click();
	}
	public void Enter_value_to_search_bar(String value)
	{
		search_bar.sendKeys(value);
		search_btn.click();
	}
	
	public boolean validate_search_box_function()
	{
		WebElement editicon=driver.findElement(By.xpath(""));
		return editicon.isDisplayed();
//		boolean result=true;
//		WebElement editicon=driver.findElement(By.xpath(""));
//		if(editicon.isDisplayed())
//		{
//			result=true;
//		}
//		return result;
	}
	
	
	public boolean verify_add_new_button()
	{
		try
		{
		return (add_btn.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public boolean verify_search_bar()
	{
		try
		{
		return (search_bar.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void validate_footer_text()
	{
		String text=driver.findElement(By.xpath("")).getText();
		System.out.println(text);
		int total_classes=Integer.parseInt(text.substring(text.indexOf("are")+1,text.indexOf("classes")-1));
		System.out.println("total classes are:"+total_classes);
		
	}
	
	
	public boolean verify_pagination_controls()
	{
		boolean result=false;
		for(WebElement control:pagi_controls)
		{
		if(control.isDisplayed())
		{
			result=true;
		}
		}
		return result;	
	}
	
	
	public void validate_number_entries()
	{
		String text=driver.findElement(By.xpath("")).getText();
		int total_pages=Integer.parseInt(text.substring(text.indexOf("of")+1,text.indexOf("entries")-1));
		for(int p=1; p<=total_pages; p++)
		{
			if(total_pages>1)
			{
			//getting active page
			WebElement active_page=driver.findElement(By.xpath(""));
			System.out.println("active page is: "+active_page.getText());
			active_page.click();
			}
			
			//getting no. of rows on active page
			int rows=driver.findElements(By.xpath("")).size();
			System.out.println("no. of rows are: "+rows);
			
		}
	}
	
	
	public boolean Verify_presence_Of_checkbox()	//in each row
	{
		boolean result=false;
		for(WebElement check:checkboxes)
		{
			if(check.isDisplayed())
			{
				result=true;
			}
		}
		return result;
	}
	
	
	
	public boolean verify_PresenceOfsortArrows_Except_EditDelete()
	{
		boolean result=false;
		for(WebElement header:tableHeadings)
		{
			if(!header.getText().trim().equals("EditDelete"))
			{
				if(!sortArrows.isEmpty())
				{
					result=true;
				}
			}
		}
		return result;
	}
	
	
	
	public boolean verify_Delete_icon_displayed()
	{
		boolean result=false;
		for(WebElement tableEntries:entries) 
		{
			if(tableEntries.isDisplayed())
			{
				for(WebElement icon:deleteIcon)
				{
					icon.isDisplayed();
					break;
				}
			}
			result=true;
		}
		return result;
	}
	
	public boolean verify_Edit_Icon_visible() //only if entries are available
	{
		boolean result=false;
		for(WebElement tableEntries:entries) 
		{
			if(tableEntries.isDisplayed())
			{
				for(WebElement icon:editIcon)
				{
					icon.isDisplayed();
					break;
				}
			}
			result=true;
		}
		return result;
	}
	
	
	public boolean verify_table_column_headers()
	{
		boolean result=false;
		for(WebElement text:tableHeadings)
		{
			if(text.isDisplayed());
			{
				result=true;
			}
		}
		return result;
		
		
	}
	
	public boolean verify_Delete_button()
	{
		try
		{
		return (delete_btn.isEnabled());
		}
		catch(Exception e)
		{
			return false;
		}
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
	
	
	public boolean validateClassURL(String exp_url)
	{
		boolean result=false;
		if(driver.getCurrentUrl().equalsIgnoreCase(exp_url))
		{
			result=true;
		}
		return result;
	}
	
	public boolean verify_Manage_class_header()
	{
		try
		{
		return (header.isDisplayed());
		}
		catch(Exception e)
		{
		return false;
		}
		
		
	}
	

	
}



