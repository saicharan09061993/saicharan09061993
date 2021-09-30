package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {
private WebDriver driver;
private long pageLoadOutTime;
private long elementDetectionTimeout;
public WebDriver getDriver() {
	return driver;
}

public void setPageLoadOutTime(long pageLoadOutTime) 
{
	this.pageLoadOutTime = pageLoadOutTime;
}

public void setElementDetectionTimeout(long elementDetectionTimeout) {
	this.elementDetectionTimeout = elementDetectionTimeout;
}
Properties prop;
public CommonDriver() throws IOException 
{
	FileInputStream fis= new FileInputStream("C:\\Users\\91995\\eclipse-workspace\\MAven2\\src\\main\\java\\resources\\dataproperties");
	 prop= new Properties();
	prop.load(fis);
	String browserType=prop.getProperty("browser");
	if(browserType.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver.exe");
		 driver =new ChromeDriver();
		
	}
	else if(browserType.contains("firefox"))
	{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\91995\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
	 driver =new FirefoxDriver();

	}
	else if(browserType.contains("ie")) 
	{
		System.setProperty("webdriver.gecko.driver", ""); 
          driver =new FirefoxDriver();
 
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	pageLoadOutTime=20l;
	elementDetectionTimeout=20l;
	}
public void openBrowserAndNavigateTo() throws Exception
{
	String Url=prop.getProperty("Url");
	driver.get(Url);
	
}
public String getTitle()throws Exception
{
	return driver.getTitle();
}
public String getCurrenturl()throws Exception
{
	return driver.getCurrentUrl();
}
public String getPagesource()throws Exception
{
	return driver.getPageSource();
}
public void navigateToUrl()throws Exception
{
	String Url=prop.getProperty("Url");
	driver.navigate().to(Url);
}
public void navigateForward() throws Exception
{
	driver.navigate().forward();
}
public void navigateBack() throws Exception
{
	driver.navigate().back();;
}
public void refresh() throws Exception
{
	driver.navigate().refresh();
}
public void closeCurrentBrowser() throws Exception{
	driver.close();
}
public void closeBrowser()throws Exception
{
	driver.quit();
}
public String getScreenshotPath(String testcasename,WebDriver driver) throws IOException
{
	TakesScreenshot t=(TakesScreenshot)driver;
	File src=t.getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+testcasename+".png";
	FileUtils.copyFile(src,new File( destinationFile));
	return testcasename;
	
}
}


















