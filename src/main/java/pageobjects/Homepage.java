package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Homepage  {
	private WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By username=By.id("txtUsername");
    private	By password=By.id("txtPassword");
    private	By loginButton=By.id("btnLogin");
    private	By spamMesage=By.id("spanMessage");
	

    
  public WebElement username()
  {
	  return driver.findElement(username);
  }
  public WebElement password()
  {
	  return driver.findElement(password);
  }
  public WebElement loginButton()
  {
	  return driver.findElement(loginButton);
  }
  public WebElement spamMesage()
  {
	  return driver.findElement(spamMesage);
  }
    
    
    
    
    

}
