package Testing.MAven2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.AssignLeaveModule;
import pageobjects.Homepage;
import resources.CommonDriver;

public class AssignLeaveModule1 {
	public WebDriver driver;
	public CommonDriver cmn;
	public static Logger log= LogManager.getLogger(AssignLeaveModule.class.getName());
	@BeforeTest
	public void intialization() throws IOException
	{
		cmn=new CommonDriver();
		driver=cmn.getDriver();
		log.info("driver is intialized");
	}
    @Test
    public void TC002() 
    {
    	try {
			cmn.openBrowserAndNavigateTo();
			/*Homepage hm =new Homepage(driver);
			hm.username().sendKeys("Admin");
			hm.password().sendKeys("admin123");
			hm.loginButton().click();*/
			AssignLeaveModule asn=new AssignLeaveModule(driver);
			asn.assignLeave().click();
			asn.employeeName().sendKeys("Prajakta Dhumal");
			asn.leaveType().selectByIndex(1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
