package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By loginEmail=By.xpath("//input[@id='user_email']");
	public WebElement getEmail()
	{
		return driver.findElement(loginEmail);
	}
	
	By loginPassword=By.xpath("//input[@id='user_password']");
	public WebElement getPassword()
	{
		return driver.findElement(loginPassword);
	}
	
	By loginButton=By.xpath("//input[@value='Log In']");
	public WebElement getloginButton()
	{
		return driver.findElement(loginButton);
	}
	
	
}
