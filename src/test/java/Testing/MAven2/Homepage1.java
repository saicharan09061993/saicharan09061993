package Testing.MAven2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobjects.Homepage;
import resources.CommonDriver;

public class Homepage1 {
	public CommonDriver cmn;
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Homepage1.class.getName());
	@BeforeMethod
	public void navigation() throws Exception
	{
		try {
			cmn=new CommonDriver();
			driver=cmn.getDriver();
			log.info("assigning driver is successful");
		  cmn.openBrowserAndNavigateTo();
		    log.info("browser is opening");
		    log.info("saicharan");
		    
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   @Test(dataProvider="getData")
   public void TC001Login(String use,String pas)
   {
	   Homepage hm=new Homepage(driver);
	   try {
		  // cmn=new CommonDriver();
		 //  cmn.openBrowserAndNavigateTo();
          hm.username().sendKeys(use);
          log.info("username is typing successfully.");
          hm.password().sendKeys(pas);
          log.info("password is typing successfully.");

          hm.loginButton().click();
		    Thread.sleep(3000);
		System.out.println(cmn.getTitle());
		System.out.println(cmn.getCurrenturl());
		if(cmn.getCurrenturl().contains("validateCredentials"))
				{
			System.out.println(hm.spamMesage().getText());
			if(hm.spamMesage().getText().contains("Invalid credentials"))
					{
				Assert.assertTrue(hm.spamMesage().getText().contains("Invalid credentials"));
					}
				
		else if(hm.spamMesage().getText().contains("Password cannot be empty"))
		{
	Assert.assertTrue(hm.spamMesage().getText().contains("Password cannot be empty"));
		}
	
	   else if(hm.spamMesage().getText().contains("Username cannot be empty"))
		{
	Assert.assertTrue(hm.spamMesage().getText().contains("Username cannnot be empty"));
		}
				}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   @AfterMethod
	public void close() throws Exception
	{
		cmn.closeBrowser();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[4][2];
		data [0][0]= "Admin";
		data [0][1]= "admin123";
		
		data [1][0]= "nareshit";
		data [1][1]= "nareshit";
		
		data [2][0]= "Admin";
		data [2][1]= "";
		
		data [3][0]= "";
		data [3][1]= "nareshit";
		
		
		return data;
	}
}
