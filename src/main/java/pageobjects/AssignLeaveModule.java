package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AssignLeaveModule {
	public WebDriver driver;
	public AssignLeaveModule(WebDriver driver)
	{
		this.driver=driver;
		}
	
	By assignleave=By.linkText("Assign Leave");
	By employeeName=By.name("assignleave[txtEmployee][empName]");
	By LeaveType=By.id("assignleave_txtLeaveType");
	By fromDate=By.id("assignleave_txtFromDate");
	By selectMonth=By.className("ui-datepicker-month");
	By selectDate=By.className("ui-state-default ui-state-highlight ui-state-active");
	By toDate=By.id("assignleave_txtToDate");
	By toSelectMonth=By.xpath("//select[@class='ui-datepicker-month']");
	By toSelectDate=By.xpath("//a[@class='ui-state-default']");
	By button=By.id("assignBtn");
	public WebElement assignLeave()
	{
		Homepage hm =new Homepage(driver);
		hm.username().sendKeys("Admin");
		hm.password().sendKeys("admin123");
		hm.loginButton().click();
		return driver.findElement(assignleave);
	}
	public WebElement employeeName()
	{
	
		return driver.findElement(employeeName);
	}
	public Select leaveType() 
	{
	       Select dropdown=new Select(driver.findElement(LeaveType));
	       return dropdown;
	}
	public WebElement fromDate()
	{
		return driver.findElement(fromDate);
	}
	public Select selectMonth()
	{
		Select dp=new Select(driver.findElement(selectMonth));
		return dp;
	}
	public WebElement selectDate()
	{
		return driver.findElement(selectDate);
	}
	public WebElement toDate() {
		return driver.findElement(toDate);
	}
	public Select toSelectMonth() 
	{
	       Select dropdown=new Select(driver.findElement(toSelectMonth));
	       return dropdown;
	}
	public List toSelectDate()
	{
		List<WebElement> dates=driver.findElements(toSelectDate);
		return dates;
	}
	public WebElement button()
	{
		return driver.findElement(button);
	}
	

}

