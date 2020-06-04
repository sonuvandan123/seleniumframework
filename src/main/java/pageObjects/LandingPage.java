package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public By login=By.cssSelector("a[href*='sign_in']");
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	By getCourseHeading= By.xpath("//div[@class='text-center']");	
	public WebElement getcourseTitle()
	{
		return driver.findElement(getCourseHeading);
	}
	
	By menubar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	public WebElement getMenuBar()
	{
		return driver.findElement(menubar);
	}
	
	
}
